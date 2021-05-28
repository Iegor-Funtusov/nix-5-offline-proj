package com.nix.hw.lib.crudImplementation;

import com.nix.hw.lib.CrudService;
import com.nix.hw.lib.Entity;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@Deprecated
public class ArrayCrudService<E extends Entity> implements CrudService<E> {

    Object[] arr = new Object[0];

    @Override
    public void create(E obj) {
        obj.setId(UUID.randomUUID().toString());
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length-1] = obj;
    }

    @Override
    public void update(E obj) {
        E currentObj = findById(obj.getId());
        try {
            BeanUtils.copyProperties(currentObj, obj);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (id.equals(((E) arr[i]).getId())) {
                index = i;
                break;
            }
        }
        for (int i = index; i < arr.length-1; i++) {
            arr[i] = arr[i + 1];
        }
        arr = Arrays.copyOf(arr, arr.length - 1);
    }

    @Override
    public E read(String id) {
        return findById(id);
    }

    @Override
    public Collection<E> read() {

        Collection<E> list = new ArrayList<E>();
        for (int i = 0; i < arr.length; i++) {
            list.add((E) arr[i]);
        }

        return list;
    }

    private E findById(String id) {
        for (Object obj : arr) {
            if (((E) obj).getId().equals(id))
                return (E) obj;
        }
        throw new RuntimeException("object not found");
    }
}
