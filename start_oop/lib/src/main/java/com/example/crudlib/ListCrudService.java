package com.example.crudlib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Deprecated
public class ListCrudService<E extends BaseEntity> implements CrudService<E> {

    List<E> entityList = new ArrayList<>();

    public ListCrudService() {
        System.out.println("ListCrudService.ListCrudService");
    }

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        entityList.add(e);
    }

    @Override
    public void update(E e) {
        E current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        entityList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public E read(String id) {
        return findById(id);
    }

    @Override
    public List<E> read() {
        return entityList;
    }

    private String generateId(String id) {
        if (entityList.stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    private E findById(String id) {
        E entity = entityList
                .stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("entity not exist");
        }
        return entity;
    }
}