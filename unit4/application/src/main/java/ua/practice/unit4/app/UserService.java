package ua.practice.unit4.app;


import ua.practice.unit4.lib.CrudFactory;
import ua.practice.unit4.lib.CrudService;

import java.util.Collection;

public class UserService implements CrudService<User> {

    CrudService<User> userCrudService;

    public UserService(String implementationName) {
        this.userCrudService = CrudFactory.getInstance().getCurrent(implementationName);
    }

    public void create(User user) {
        userCrudService.create(user);
    }

    public void delete(String id) {
        userCrudService.delete(id);
    }

    public void update(User user) {
        userCrudService.update(user);
    }

    public User read(String id) {
        return userCrudService.read(id);
    }

    public Collection<User> read() {
        return userCrudService.read();
    }
}