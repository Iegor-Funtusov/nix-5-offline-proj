package ua.com.alevel.lib;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Deprecated
public class SetCrudService<E extends BaseEntity> implements CrudService<E> {

    private final int SIZE = 100;
    private final Object[] arr = new Object[SIZE];
    private int size;

    public void create(E e) {
        if (e == null) {
            throw new IllegalArgumentException("entity is null");
        }
        e.setId(generateId(UUID.randomUUID().toString()));
        arr[size++] = e;
    }

    public void update(E e) {
        E current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            E current = findById(id);
            if (current == null) {
                throw new RuntimeException("entity is not exist");
            }
            for (int i = 0; i < size; i++) {
                if (((E) arr[i]).getId().equals(id)) {
                    arr[i] = null;
                    System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                    arr[--size] = null;
                }
            }
        } else {
            throw new RuntimeException("entity is not exist");
        }

    }

    public Collection<E> read() {
        return Arrays.stream(arr)
                .map(e -> ((E) e))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public E read(String id) {
        if (StringUtils.isNotBlank(id)) {
            E current = findById(id);
            if (current == null) {
                throw new RuntimeException("entity is not exist");
            }
            return current;
        } else {
            throw new RuntimeException("entity is not exist");
        }
    }

    private E findById(String id) {
        return (E) Arrays.stream(arr)
                .filter(e -> ((E) e).getId().equals(id))
                .findAny()
                .orElse(null);
    }

    private String generateId(String id) {
        if (Arrays
                .stream(arr)
                .filter(Objects::nonNull)
                .anyMatch(e -> ((E) e)
                        .getId()
                        .equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
}