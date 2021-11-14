package ua.com.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListCrudService<E extends BaseEntity> implements CrudService<E> {

    List<E> list = new ArrayList<>();

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        list.add(e);
    }

    @Override
    public E read(String id) {
        return findById(id);
    }

    @Override
    public List<E> readAll() {
        return list;
    }

    @Override
    public void update(E e) {
        E current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        list.removeIf(e -> e.getId().equals(id));
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
        return entity;
    }

}
