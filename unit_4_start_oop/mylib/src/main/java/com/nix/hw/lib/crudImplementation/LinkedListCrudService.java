package com.nix.hw.lib.crudImplementation;

import com.nix.hw.lib.CrudService;
import com.nix.hw.lib.Entity;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

//@Deprecated
public class LinkedListCrudService<E extends Entity> implements CrudService<E> {

    LinkedList<E> list = new LinkedList<>();

    @Override
    public void create(E obj) {
        obj.setId(UUID.randomUUID().toString());
        list.add(obj);
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
        list.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public E read(String id) {
        return findById(id);
    }

    @Override
    public Collection<E> read() {
        return list;
    }

    private E findById(String id) {
        E obj = list.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if (obj == null) {
            throw new RuntimeException("object not found");
        }
        return obj;
    }
}
