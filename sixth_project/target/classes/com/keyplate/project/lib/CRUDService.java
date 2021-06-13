package com.keyplate.project.lib;

import java.util.Collection;

public interface CRUDService<T extends BaseEntity>{

    void update(long id, T entity);

    void delete(long id);

    void create(T entity);

    T read(long id);

    BaseEntityContainer<T> readAll();
}
