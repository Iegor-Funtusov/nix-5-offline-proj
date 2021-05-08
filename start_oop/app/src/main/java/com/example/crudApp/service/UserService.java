package com.example.crudApp.service;

import com.example.crudApp.model.User;

import java.util.Collection;

public interface UserService {

    void create(User user);
    void delete(String id);
    void update(User user);
    User read(String id);
    Collection<User> read();
}
