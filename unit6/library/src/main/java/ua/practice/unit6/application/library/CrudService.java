package ua.practice.unit6.application.library;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public interface CrudService<E extends BaseEntity> {
    void create(E e);
    void update(E e);
    void delete(String id);

    Collection<E> read();

    E read(String id);
}
