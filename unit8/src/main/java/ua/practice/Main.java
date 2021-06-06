package ua.practice;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        try {
            ui.execute();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
