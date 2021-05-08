package org.example.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class ObjectArrCrudService<E extends  BaseEntity> implements CrudService<E> {

    Object[] array  = new Object[10];
    private int iter = 0;

    public  void create(E e) {
        if (iter >= array.length) {
            int newSize = array.length + 1;
            array = Arrays.copyOf(array, newSize);
        }
        e.setId(UUID.randomUUID().toString());
        array[iter] = e;
        iter++;

    }

    public  E read(String id) {
        return (E) findBuId(id);
    }

    public  void update(E e) {
        E current = (E) findBuId(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (IllegalAccessException | InvocationTargetException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    public  void delete(String id) {
        if (!id.isBlank()) {
            E current = (E) findBuId(id);
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(current)) {
                    System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                    iter--;
                }
            }
        } else {
            throw new RuntimeException("id not found");
        }
    }

    public Collection<E> read() {
        return Arrays
                .stream(array)
                .limit(array.length)
                .map(o -> ((E) o))
                .collect(Collectors.toList());
    }

    private Object findBuId (String id) {
        E entity = (E) Arrays
                .stream(array)
                .filter(el -> ((E) el).getId().equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("entity not exist");
        }
        return entity;
    }
}
