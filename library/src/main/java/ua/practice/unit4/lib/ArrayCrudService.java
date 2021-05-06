package ua.practice.unit4.lib;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class ArrayCrudService<E extends BaseEntity> implements CrudService<E> {

    BaseEntity[] list = new BaseEntity[0];

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        BaseEntity[] newList = new BaseEntity[list.length + 1];
        newList[list.length] = e;
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }

    @Override
    public void update(E e) {
        int index = findIndexById(e.getId());
        E current = (E) list[index];
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        list[index] = current;
    }

    @Override
    public void delete(String id) {
        int index = findIndexById(id);
        list = ArrayUtils.remove(list, index);
    }

    @Override
    public Collection<E> read() {
        return (List<E>) List.of(list);
    }

    @Override
    public E read(String id) {
        return (E) list[findIndexById(id)];
    }


    private String generateId(String id) {
        if (Stream.of(list).anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
    private int findIndexById(String id) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
}
