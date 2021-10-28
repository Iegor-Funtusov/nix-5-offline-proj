package org.example.dao;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.BaseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dao<E extends BaseEntity> {
    private static final Logger logger = LogManager.getLogger(Dao.class);
    private static final int DEFAULT_SIZE = 10;

    private long idCounter = 0;

    private int numberOfElements = 0;
    private Object[] container = new Object[DEFAULT_SIZE];

    public String create(E e) {
        logger.debug("Start create " + e);
        if (numberOfElements + 1 > container.length) {
            grow();
        }
        e.setId(e.getClass().getSimpleName() + nextId());
        container[numberOfElements] = e;
        numberOfElements++;

        logger.info("Success create");
        logger.debug("End create");
        return e.getId();
    }

    public void update(E e) {
        logger.debug("Start update " + e);
        Object current = findById(e.getId());
        try {
//            Object temp = BeanUtils.cloneBean(e);
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            logger.error("Update failed", ex);
            throw new RuntimeException(ex.getMessage());
        }
        logger.warn("Success update");
        logger.debug("End update");
    }

    public void delete(String id) {
        logger.debug("Start delete " + id);
        int location = -1;
        for (int i = 0; i < numberOfElements; i++) {
            if (((E) container[i]).getId().equals(id)) {
                location = i;
            }
        }
        if (location < 0) {
            logger.error("Delete failed as Element does not exist");
            throw new IllegalArgumentException("Element does not exist");
        }

        container[location] = null;
        if (location < numberOfElements - 1) {
            System.arraycopy(container, location + 1, container, location, numberOfElements - 1 - location);
        }
        numberOfElements--;
        logger.warn("Success delete");
        logger.debug("End delete");
    }

    public List<E> read() {
        logger.debug("Start read");
        return Arrays
                .stream(container)
                .limit(numberOfElements)
                .map(o -> ((E) o))
                .collect(Collectors.toList());
    }

    public E read(String id) {
        logger.debug("Start read " + id);
        return (E) findById(id);
    }

    private void grow() {
        logger.debug("Start grow");
        int newCapacity = container.length + 1 + container.length / 2;
        container = Arrays.copyOf(container, newCapacity);
        logger.debug("End grow");
    }

    private Object findById(String id) {
        logger.debug("Start findById " + id);
        Object entity = Arrays
                .stream(container)
                .limit(numberOfElements)
                .filter(o -> ((E) o).getId().equals(id)).findAny().orElse(null);
        logger.debug("End findById");
        return entity;
    }

    private long nextId() {
        return idCounter++;
    }
}
