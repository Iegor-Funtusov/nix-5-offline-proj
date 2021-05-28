package ua.com.nix;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Solution().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
