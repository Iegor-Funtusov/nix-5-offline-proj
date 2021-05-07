package ua.com.alevel.lib;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ArrayCrudService <E extends BaseEntity> implements CrudService<E> {
    Object[] arrObjects = new Object[0];
    private int numberOfElement = 2;
    public ArrayCrudService() {
        System.out.println("ArrayCrudService.ArrayCrudService");
    }
    @Override
    public void create(E e){
        e.setId(generateId(UUID.randomUUID().toString()));
        Object[] arrObjectsForSave = new Object[arrObjects.length + 1];
        arrObjectsForSave[arrObjects.length] = e;
        System.arraycopy(arrObjects, 0, arrObjectsForSave, 0, arrObjects.length);
        arrObjects = arrObjectsForSave;
    }

    @Override
    public void update(E e) {
        int index = findIndex(e.getId());
        E current = (E) arrObjects[index];
        try{
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }



    @Override
    public void delete(String id) {
        int index = findIndex(id);
        arrObjects = ArrayUtils.remove(arrObjects, index);
    }

    @Override
    public Collection<E> read() {
        return Arrays.stream(arrObjects).map(e2-> ((E) e2)).collect(Collectors.toList());

    }

    @Override
    public E read(String id) {
        return (E) arrObjects[findIndex(id)];
    }

    private String generateId(String id) {
        if (Stream.of(arrObjects).anyMatch(e -> ((E) e).getId().equals(id))){
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
    private int findIndex(String id) {
        for(int i = 0; i < arrObjects.length; i++){
            if(((E) arrObjects[i]).getId().equalsIgnoreCase(id))
                return i;
        }
        return 1;
    }
}
