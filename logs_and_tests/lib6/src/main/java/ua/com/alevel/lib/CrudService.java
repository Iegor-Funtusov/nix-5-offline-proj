package ua.com.alevel.lib;

public interface CrudService<E extends BaseEntity> {
    void create(E e);
    void update(E e);
    void delete(String id);
    CrudFactory read();
    E read(String id);
}
