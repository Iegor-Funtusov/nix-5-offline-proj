package ua.com.alevel.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.UUID;

public class ArrayCrudService<E extends BaseEntity> implements CrudService<E> {
    private final CrudFactory crudFactory = new CrudFactory();

    @Override
    public void create(E e) {
        e.setId(UUID.randomUUID().toString());
        crudFactory.add(e);
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
        crudFactory.remove(crudFactory.indexOf(getEntityById(id)));
    }

    @Override
    public E read(String id) {
        return getEntityById(id);
    }

    public CrudFactory read() {
        CrudFactory list = new CrudFactory();
        for (int i = 0; i < crudFactory.size(); i++) {
            list.add(( crudFactory.get(i)));
        }
        return list;
    }

    private E getEntityById(String id) {
        E entity;
        for (int i = 0; i < crudFactory.size(); i++) {
            entity = (E) crudFactory.get(i);
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    public int size() {
        return crudFactory.size();
    }
}
