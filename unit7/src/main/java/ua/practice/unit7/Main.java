package ua.practice.unit7;

import ua.practice.unit7.ui.UserUI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        try {
            userUI.execute();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
