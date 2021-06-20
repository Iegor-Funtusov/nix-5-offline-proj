package ua.practice.crud_library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class ArrayCrudService<E extends BaseEntity> implements CrudService<E> {

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        ArrayList<String[]> csvData = new ArrayList<>();
        AccessToClass.addFieldsValuesToCsv(e, csvData);
        IOProcessor.inputDataToFile(e.getClass(), csvData);
    }

    @Override
    public void update(E e) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Collection<E> read()
    {
        return null;
    }

    @Override
    public E read(String id) throws ArrayIndexOutOfBoundsException {
        return null;
    }


    private String generateId(String id) {
//        if (Stream.of(list).anyMatch(e -> ((E) e).getId().equals(id))) {
//            return generateId(UUID.randomUUID().toString());
//        }
        return id;
    }

    private int findIndexById(String id) {

        return -1;
    }
}