package ua.com.lib;

import java.util.Collection;

public interface CrudService<E extends BaseEntity> {
    void create(E e);

    E read(String id);

    Collection<E> readAll();

    void update(E e);

    void delete(String id);
}
