package com.example.unit1.dao;

import main.java.com.example.unit1.db.MainDb;
import main.java.com.example.unit1.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private final MainDb mainDb = new MainDb();

    @Override
    public List<User> getAllUsers() {
        return mainDb.getAllUsers();
    }

    @Override
    public void create(User user) {
        mainDb.addUser(user);
    }

    @Override
    public void update(User user) {
        mainDb.updateUser(user);
    }

    @Override
    public void deleteById(String id) {
        mainDb.deleteUserById(id);
    }

}