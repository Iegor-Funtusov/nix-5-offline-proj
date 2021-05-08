package ua.com.alevel.lib;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayCrudService <E extends BaseEntity> implements CrudService<E> {

    Object[] arrayObj = new Object[0];

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        Object[] newArrayObj = new Object[arrayObj.length + 1];
        newArrayObj[arrayObj.length] = e;
        System.arraycopy(arrayObj, 0, newArrayObj, 0, arrayObj.length);
        arrayObj = newArrayObj;
    }

    @Override
    public void update(E e) {
        int indexID = findIndexById(e.getId());
        E curr = (E) arrayObj[indexID];
        try {
            BeanUtils.copyProperties(curr, e);
        } catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
        arrayObj[indexID] = curr;
    }

    @Override
    public void delete(String id) {
        int indexID = findIndexById(id);
        arrayObj = ArrayUtils.remove(arrayObj, indexID);
    }

    @Override
    public Collection<E> read() {
        return Arrays.stream(arrayObj).map(el -> ((E) el)).collect(Collectors.toList());
    }

    @Override
    public E read(String id) {
        return (E) arrayObj[findIndexById(id)];
    }

    private String generateId(String id) {
        if (Stream.of(arrayObj).anyMatch(el ->((E) el).getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
    private int findIndexById(String id) {
        for (int i = 0; i < arrayObj.length; i++) {
            if (((E) arrayObj[i]).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
}
