package ua.com.davidenko.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListCrudService<E extends BaseEntity> implements CrudService<E> {

    List<E> list = new ArrayList<>();

    public ListCrudService() {}

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        list.add(e);
    }

    @Override
    public void update(E e) {
        E current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException("Some Exeption");
        }
    }

    @Override
    public void delete(String id) {
        list.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public E read(String id) {
        return findById(id);
    }

    @Override
    public List<E> read() {
        return list;
    }

    private String generateId(String id) {
        if (list.stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    private E findById(String id) {
        E entity = list
                .stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("No such id : " + id);
        }
        return entity;
    }
}