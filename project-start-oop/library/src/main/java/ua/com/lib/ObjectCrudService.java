package ua.com.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;

@Deprecated
public class ObjectCrudService<E extends BaseEntity> implements CrudService<E> {

    public static void main(String[] args) {
    }

    Object[] objectsArray = new Object[0];
    private static int size = 0;

    @Override
    public void create(E e) {
//        e.setId(String.valueOf(size+1));
        Object[] newArray = new Object[size + 10];
        if (size + 1 > objectsArray.length) {
            System.arraycopy(objectsArray, 0, newArray, 0, size);
            objectsArray = newArray;
        }
        e.setId(String.valueOf(size+1));
        objectsArray[size] = e;
        size++;
    }

    public static int size() {
        return size;
    }

    @Override
    public E read(String id) {
        return (E) objectsArray[Integer.parseInt(id)];
    }

    @Override
    public Collection readAll() {
        Collection<E> list = new ArrayList<E>();
        for (int i = 0; i < size; i++) {
            list.add((E) objectsArray[i]);
        }

        return list;
    }

    @Override
    public void update(E e) {
        int id = Integer.parseInt(e.getId());
        E current = (E) objectsArray[id];
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        objectsArray[id] = current;
    }

    @Override
    public void delete(String id) {
        Object[] newArray = new Object[size - 1];
        int index = Integer.parseInt(id);
        if(index==0){
            System.arraycopy(objectsArray,0,newArray,1,size-1);
        }else if(index == size-1){
            System.arraycopy(objectsArray,0,newArray,0,size-1);
        }else{
            System.arraycopy(objectsArray,0,newArray,0,index);
            int elementAfterIndex = objectsArray.length - index - 2;
            System.arraycopy(objectsArray, index + 1, newArray, index, elementAfterIndex);
        }
        objectsArray = newArray;
        size--;
    }

}
