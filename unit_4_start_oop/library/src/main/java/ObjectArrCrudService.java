import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class ObjectArrCrudService <E extends BaseEntity> implements CrudServiceInterface<E> {
    Object[] arr = new Object[0];

    public ObjectArrCrudService() {
        System.out.println("ObjectArrCrudService");
    }

    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        Object[] newArray = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[arr.length] = e;
        arr = newArray;
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
        int index = getIndexById(id);
        arr = ArrayUtils.remove(arr, index);

    }

    public E get(String id) {
        return findById(id);
    }

    public Collection<E> getAll() {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add((E)arr[i]);
        }
        return list;
    }

    private String generateId(String id) {
        if (getAll().stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    private E findById(String id) {
        return (E)arr[getIndexById(id)];
    }

    private int getIndexById(String id){
        for (int i = 0; i < arr.length; i++) {
            if(((E) arr[i]).getId().equals(id))
            {
                return i;
            }
        }
        System.out.println("ID not found");
        return -1;
    }
}
