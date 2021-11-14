package ua.com.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.UUID;

public class ArrayCrudService<E extends Entity> implements Crud<E> {

    private final ArrayImpl arrayImpl = new ArrayImpl();

    @Override
    public void create(E e) {
        e.setId(UUID.randomUUID().toString());
        arrayImpl.add(e);
    }

    @Override
    public E read(String id) {
        return getEntityById(id);
    }

    @Override
    public void update(E e) {
        E current = getEntityById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        arrayImpl.remove(arrayImpl.indexOf(getEntityById(id)));
    }

    public ArrayImpl readAll() {
        ArrayImpl list = new ArrayImpl();
        for (int i = 0; i < arrayImpl.size(); i++) {
            list.add(( arrayImpl.get(i)));
        }
        return list;
    }

    private E getEntityById(String id) {
        E entity;
        for (int i = 0; i < arrayImpl.size(); i++) {
            entity = (E) arrayImpl.get(i);
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    public int size() {
        return arrayImpl.size();
    }
}
