package ua.practice.unit4.app;

import ua.practice.unit4.lib.CrudFactory;
import ua.practice.unit4.lib.CrudService;

import java.util.Collection;

public class CarService implements CrudService<Car> {

    CrudService<Car> carCrudService;

    public CarService(String implementationName) {
        this.carCrudService = CrudFactory.getInstance().getCurrent(implementationName);
    }

    public void create(Car car) {
        carCrudService.create(car);
    }

    public void delete(String id) {
        carCrudService.delete(id);
    }

    public void update(Car car) {

        carCrudService.update(car);
    }

    public Car read(String id) {
        return carCrudService.read(id);
    }

    public Collection<Car> read() {
        return carCrudService.read();
    }

}
