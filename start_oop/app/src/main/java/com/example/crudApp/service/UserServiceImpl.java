package com.example.crudApp.service;

import com.example.crudApp.model.User;
import com.example.crudlib.CrudFactory;
import com.example.crudlib.CrudService;

import java.util.Collection;

public class UserServiceImpl implements UserService{
    CrudService<User> userCrudService = CrudFactory.getInstance().getCurrent();

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
