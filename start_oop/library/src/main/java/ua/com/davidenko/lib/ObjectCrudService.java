package ua.com.davidenko.lib;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class ObjectCrudService<E extends BaseEntity> implements CrudService<E> {

    Object[] array = new Object[0];

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        Object[] newArray = new Object[array.length + 1];
        newArray[array.length] = e;
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        if (e == null) {
            throw new RuntimeException(" Array is null");
        }
    }

    @Override
    public void update(E e) {
        int numId = findById(e.getId());
        E current = (E) array[numId];
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong");
        }
    }

    @Override
    public void delete(String id) {
        int numId = findById(id);
        array = ArrayUtils.remove(array, numId);
    }

    @Override
    public Collection<E> read() {
        return Arrays.stream(array).map(e -> ((E) e))
                .collect(Collectors.toList());
    }

    @Override
    public E read(String id) {
        return (E) array[findById(id)];
    }

    private String generateId(String id) {
        if (Arrays.stream(array).anyMatch(e -> ((E) e).getId().equals(id))) {
            return generateId(generateId(UUID.randomUUID().toString()));
        }
        return id;
    }

    private int findById(String id) {
        for (int i = 0; i < array.length; i++) {
            if (((E) array[i]).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
}










