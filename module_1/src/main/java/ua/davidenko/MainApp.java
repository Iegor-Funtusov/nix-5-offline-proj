package ua.davidenko;

import ua.davidenko.level_1.Level_1_Main;
import ua.davidenko.level_2.task_1.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter LEVEL number:");
        System.out.println("LEVEL 1: Unique element, Chess, Triangle Area");
        System.out.println("LEVEL 2: String pars Valid");
        System.out.println("LEVEL 3: Game Life");
        String option = br.readLine();
        switch (option) {
            case "1":
                Level_1_Main.level_1_Choose();
            case "2":
                Main.startString();
        }
    }
}
