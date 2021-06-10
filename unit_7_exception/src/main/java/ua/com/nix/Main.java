package ua.com.nix;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        try {
            new DateCreate().dateCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
