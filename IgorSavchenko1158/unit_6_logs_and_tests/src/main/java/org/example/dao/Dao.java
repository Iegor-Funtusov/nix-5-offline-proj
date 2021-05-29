package org.example.dao;

import org.apache.commons.beanutils.BeanUtils;
import org.example.entity.BaseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dao<E extends BaseEntity> {
    private static final int DEFAULT_SIZE = 10;

    private long idCounter = 0;

    private int numberOfElements = 0;
    private Object[] container = new Object[DEFAULT_SIZE];

    public String create(E e) {
        if (numberOfElements + 1 > container.length) {
            grow();
        }
        e.setId(e.getClass().getSimpleName() + nextId());
        container[numberOfElements] = e;
        numberOfElements++;

        return e.getId();
    }

    public void update(E e) {
        Object current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        int location = -1;
        for (int i = 0; i < numberOfElements; i++) {
            if (((E) container[i]).getId().equals(id)) {
                location = i;
            }
        }
        if (location < 0) {
            throw new IllegalArgumentException("Element does not exist");
        }

        container[location] = null;
        if (location < numberOfElements - 1) {
            System.arraycopy(container, location + 1, container, location, numberOfElements - 1 - location);
        }
        numberOfElements--;
    }

    public List<E> read() {
        return Arrays
                .stream(container)
                .limit(numberOfElements)
                .map(o -> ((E) o))
                .collect(Collectors.toList());
    }

    public E read(String id) {
        return (E) findById(id);
    }

    private void grow() {
        int newCapacity = container.length + 1 + container.length / 2;
        container = Arrays.copyOf(container, newCapacity);
    }

    private Object findById(String id) {
        Object entity = Arrays.stream(container)
                .filter(o -> ((E) o).getId().equals(id)).findAny().orElse(null);
        return entity;
    }

    private long nextId() {
        return idCounter++;
    }
}
