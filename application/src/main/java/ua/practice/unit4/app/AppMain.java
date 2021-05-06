package ua.practice.unit4.app;

import ua.practice.unit4.lib.ListCrudService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class AppMain {
    public static void main(String[] args) throws IOException {

        ObjectCrudService<Car> carObjectCrudService = new ObjectCrudService<>();
        Car car = new Car();
        car.setBrand("BMW");
        car.setAge("10");
        carObjectCrudService.create(car);
        car = new Car();
        car.setBrand("BMWX2");
        car.setAge("20");
        carObjectCrudService.create(car);

        carObjectCrudService.read().forEach(System.out::println);

        ListCrudService<User> listCrudService = new ListCrudService<>();
        User user = new User();
        user.setName("qq");
        user.setAge(10);
        listCrudService.create(user);

        user = new User();
        user.setName("ww");
        user.setAge(20);
        listCrudService.create(user);

        listCrudService.read().forEach(System.out::println);






//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String string;
//        while ((string = bufferedReader.readLine())!=null)
//        {
//
//        }
//
//        UserService userService = new UserService();
//        CarService carService = new CarService();
//
//        User user = new User();
//        user.setName("qq");
//        user.setAge(10);
//        userService.create(user);
//
//        user = new User();
//        user.setName("ww");
//        user.setAge(20);
//        userService.create(user);
//
//        Collection<User> users = userService.read();
//        users.forEach(System.out::println);
//
//        Car car = new Car();
//        car.setBrand("BMW");
//        car.setAge("10");
//        carService.create(car);
//        car = new Car();
//        car.setBrand("BMWX2");
//        car.setAge("20");
//        carService.create(car);
//
//        Collection<Car> cars = carService.read();
//        cars.forEach(System.out::println);
    }
}
