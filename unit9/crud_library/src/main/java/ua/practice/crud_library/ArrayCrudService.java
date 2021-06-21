package ua.practice.crud_library;

import ua.practice.crud_library.io_utils.DatabaseCreator;
import ua.practice.crud_library.io_utils.IOProcessor;

import java.util.*;
import java.util.stream.Stream;

public class ArrayCrudService<E extends BaseEntity> implements CrudService<E> {
    final Class<E> clazz;

    public ArrayCrudService(Class<E> typeE) {
        clazz = typeE;
        DatabaseCreator.createDataBasesIfNotExist(typeE);
    }

    @Override
    public void create(E e) {
        String generatedId = generateId(UUID.randomUUID().toString());
        e.setId(generatedId);
        ArrayList<String[]> csvData = new ArrayList<>();
        csvData.add(AccessToClass.addFieldsValuesToCsv(e));
        IOProcessor.inputDataToFile(e.getClass(), csvData, true);
    }

    @Override
    public void update(E e) {
        IOProcessor.updateDataInFile(e);
    }

    @Override
    public void delete(String id) {
        IOProcessor.deleteDataInFile(id, clazz);
    }

    @Override
    public Collection<E> read()
    {
        List<String[]> readData = IOProcessor.readAllData(clazz);
        return (Collection<E>) AccessToClass.convertStringsToClass(clazz,readData);
    }

    @Override
    public E read(String id) throws NoSuchElementException {
        return read().stream()
                .filter(e->e.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }


    private String generateId(String id) {
        if (Stream.of(read()).anyMatch(e -> e.equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
}