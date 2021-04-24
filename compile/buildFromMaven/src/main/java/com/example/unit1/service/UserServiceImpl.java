package com.example.unit1.service;

import com.example.unit1.dao.UserDao;
import com.example.unit1.dao.UserDaoImpl;
import com.example.unit1.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}
