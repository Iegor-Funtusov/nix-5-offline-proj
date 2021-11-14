package ua.com.lib;

public interface Crud<E extends Entity> {
    void create(E e);

    E read(String id);

    void update(E e);

    void delete(String id);

    ArrayImpl readAll();

}
