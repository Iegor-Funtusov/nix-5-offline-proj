package org.example.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
@Deprecated
public class SetCrudService<E extends  BaseEntity> implements CrudService<E> {

    Set<E> list = new HashSet<>();

    public  void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        list.add(e);
    }

    public  E read(String id) {
        return findBuId(id);
    }

    public  void update(E e) {
        E current = findBuId(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (IllegalAccessException | InvocationTargetException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    public  void delete(String id) {
        list.removeIf(e -> e.getId().equals(id));
    }

    public Set<E> read() {
        return list;
    }

    private String generateId(String id) {
        if (list.stream().anyMatch(el -> el.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    private E findBuId (String id) {
        E entity = list
                .stream()
                .filter(el -> el.getId().equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("entity not exist");
        }
        return entity;
    }
}
