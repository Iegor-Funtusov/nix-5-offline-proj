package com.example.unit1.dao;

import main.java.com.example.unit1.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void create(User user);
    void update(User user);
    void deleteById(String id);
}