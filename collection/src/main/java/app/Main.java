package app;

import app.controller.Controller;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
