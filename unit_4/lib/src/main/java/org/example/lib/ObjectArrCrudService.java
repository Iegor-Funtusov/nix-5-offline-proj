package org.example.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ObjectArrCrudService<E extends  BaseEntity> implements CrudService<E> {

    private Object[] array = new Object[2];

    private int pos = 0;

    public void create(E e) {
        if (pos + 1 > array.length) {
            int new_size = array.length + 1;
            array = Arrays.copyOf(array, new_size);
        }
        if (e != null) {
            e.setId(UUID.randomUUID().toString());
            array[pos] = e;
            pos++;
        }
    }

    public E read(String id) {
        if (!id.isBlank()) {
            return (E) findById(id);
        } else {
            throw new RuntimeException("Error: \nentity not found!!!");
        }
    }

    public Collection<E> read() {
        return Arrays
                .stream(array)
                .limit(pos)
                .map(el -> ((E) el))
                .collect(Collectors.toList());
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
        if (!id.isBlank()) {
            E current = (E) findById(id);
            for (int i = 0; i < pos; i++) {
                if(array[i].equals(current)){
                    System.arraycopy(array, i + 1, array, i, pos - i - 1);
                    pos--;
                }
            }
        } else {
            throw new RuntimeException("Error: \nentity not found!!!");
        }
    }

    private Object findById(String id) {
        Object entity = Arrays.stream(array)
                .filter(el -> ((E) el)
                        .getId()
                        .equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("Error: \nentity not found!!!");
        }
        return entity;
    }
}
