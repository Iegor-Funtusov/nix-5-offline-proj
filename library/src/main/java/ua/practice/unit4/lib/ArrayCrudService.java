package ua.practice.unit4.lib;


import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ArrayCrudService<E extends BaseEntity> implements CrudService<E> {

    BaseEntity[] list = new BaseEntity[0];

    @Override
    public void create(E e) {
        BaseEntity[] newList = new BaseEntity[list.length+1];
        newList[list.length] = e;
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }

    @Override
    public void update(E e) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Collection<E> read() {
        return (List<E>) List.of(list);
    }

    @Override
    public E read(String id) {
        return findById(id);
    }

    private E findById(String id) {
        Stream<BaseEntity> str = Stream.of(list);
        return (E) str
                .filter(element->element.getId().equalsIgnoreCase(id))
                .findAny()
                .orElseThrow(()->new RuntimeException("entity not exists"));
    }
}
