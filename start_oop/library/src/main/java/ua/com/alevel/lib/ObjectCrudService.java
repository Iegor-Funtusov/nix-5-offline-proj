package ua.com.alevel.lib;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

//@Deprecated
public class ObjectCrudService <E extends BaseEntity> implements CrudService<E>{

    private Object[] arr = new Object[10];
    private int size = 0;

    public ObjectCrudService(){
        System.out.println("ObjectCrudService.ObjectCrudService");
    }

    @Override
    public void create(E e) {
        if (size + 1 > arr.length) {
            int new_size = arr.length + 1;
            arr = Arrays.copyOf(arr, new_size);
        }
        e.setId(UUID.randomUUID().toString());
        arr[size] = e;
        size++;

    }

    @Override
    public void update(E e) {
        Object current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            E current = (E) findById(id);
            for (int i = 0; i < size; i++) {
                if(arr[i].equals(current)){
                    System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                    size--;
                }
            }
        } else {
            throw new RuntimeException("entity is not exist");
        }
    }

    @Override
    public Collection<E> read() {
        return Arrays
                .stream(arr)
                .limit(size)
                .map(o -> ((E) o))
                .collect(Collectors.toList());
    }

    @Override
    public E read(String id) {
        return (E) findById(id);
    }
    private Object findById(String id) {
        Object entity = Arrays.stream(arr)
                .filter(e -> ((E) e)
                .getId().equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("entity not exist");
        }
        return entity;
    }
}
