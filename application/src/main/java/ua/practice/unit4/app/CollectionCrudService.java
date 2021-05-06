package ua.practice.unit4.app;

import ua.practice.unit4.lib.BaseEntity;
import ua.practice.unit4.lib.CrudFactory;
import ua.practice.unit4.lib.CrudService;

import java.util.Collection;
public class CollectionCrudService<E extends BaseEntity> {
    private final CrudService<E> crudService;

    public CollectionCrudService() {
        this.crudService = CrudFactory.getInstance().getCurrent("ListCrudService");
    }

    public void create(E e) {
        crudService.create(e);
    }

    public void delete(String id) {
        crudService.delete(id);
    }

    public void update(E e) {
        crudService.update(e);
    }

    public E read(String id) {
        return crudService.read(id);
    }

    public Collection<E> read() {
        return crudService.read();
    }
}