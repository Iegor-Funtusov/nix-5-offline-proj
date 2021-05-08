package com.example.crudApp;

import com.example.crudApp.controller.UserController;

public class Main {

    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.exec();
    }
}
