package ua.com.alevel;

import java.io.IOException;

public class Module2Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}