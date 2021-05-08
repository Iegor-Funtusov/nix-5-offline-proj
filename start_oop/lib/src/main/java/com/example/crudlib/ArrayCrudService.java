package com.example.crudlib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.*;

//@Deprecated
public class ArrayCrudService <E extends BaseEntity> implements CrudService<E>{

    private int sizeOfEntities = 8;
    private int indexOfEntities = 0;

    BaseEntity[] entities = new BaseEntity[sizeOfEntities];

    public ArrayCrudService(){
        System.out.println("ArrayCrudService.ArrayCrudService");
    }

    @Override
    public void create(E e) {
        if(indexOfEntities + 1 > entities.length){
            increaseEntities();
        }
        e.setId(UUID.randomUUID().toString());
        entities[indexOfEntities] = e;
        indexOfEntities++;
    }

    private void increaseEntities(){
        sizeOfEntities = entities.length * 2;
        entities = Arrays.copyOf(entities, sizeOfEntities);
    }

    @Override
    public void update(E e) {
        E current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        for(int i = 0; i < indexOfEntities; i++){
            if(entities[i].getId().equals(id)){
                entities[i] = null;
                indexOfEntities--;
                for(int j = i+1; j < indexOfEntities+1; j++){
                    entities[j-1] = entities[j];
                    entities[j] = null;
                }
            }
        }
    }

    @Override
    public Collection<E> read() {
        return (Collection<E>) Arrays.asList(entities);
    }

    @Override
    public E read(String id) {
        return findById(id);
    }

    private E findById(String id) {
        for(BaseEntity e : entities){
            if(e.getId().equals(id)){
                return (E) e;
            }
        }
        throw new RuntimeException("entity not exist");
    }
}
