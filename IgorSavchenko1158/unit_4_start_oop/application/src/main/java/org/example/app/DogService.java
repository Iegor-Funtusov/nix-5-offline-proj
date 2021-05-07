package org.example.app;

import org.example.lib.CrudFactory;
import org.example.lib.CrudService;

import java.util.Collection;

public class DogService {

    private CrudService<Dog> dogCrudService = CrudFactory.getInstance().getCurrent();

    public void create(Dog dog) {
        dogCrudService.create(dog);
    }

    public void delete(String id) {
        dogCrudService.delete(id);
    }

    public void update(Dog dog) {
        dogCrudService.update(dog);
    }

    public Dog read(String id) {
        return dogCrudService.read(id);
    }

    public Collection<Dog> read() {
        return dogCrudService.read();
    }
}
