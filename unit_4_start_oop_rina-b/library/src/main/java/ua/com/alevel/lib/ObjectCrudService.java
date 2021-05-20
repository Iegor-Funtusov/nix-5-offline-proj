package ua.com.alevel.lib;

import org.apache.commons.beanutils.BeanUtils;
import java.util.*;
import java.util.stream.Collectors;

public class ObjectCrudService <E extends BaseEntity> implements CrudService<E>{

    private Object[] objects = new Object[5];
    private int l = 0;

    public void create(E e) {
        if (l + 1 > objects.length) {
            int nextL = objects.length + 1;
            objects = Arrays.copyOf(objects, nextL);
        }
        e.setId(UUID.randomUUID().toString());
        objects[l] = e;
        l++;

    }

    public Collection<E> read() {
        return Arrays
                .stream(objects)
                .limit(l)
                .map(o -> ((E) o))
                .collect(Collectors.toList());
    }

    public E read(String id) {

        return (E) findById(id);
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
            for (int i = 0; i < l; i++) {
                if(objects[i].equals(current)){
                    System.arraycopy(objects, i + 1, objects, i, l - i - 1);
                    l--;
                }
            }
        } else throw new RuntimeException("entity does not exist");
    }


    private Object findById(String id) {
        Object entity = Arrays.stream(objects)
                .filter(e -> ((E) e)
                        .getId()
                        .equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("entity does not exist");
        }
        return entity;
    }
}