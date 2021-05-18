package ua.davidenko.level_2.task_1;


import ua.davidenko.MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level_2_Main {
    public static void startString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose String creating:");
        System.out.println("1 - User Input String, 2 - random String, 3 - return to LEVEL UP");
        String option = br.readLine();
        switch (option){
            case "1":
                StringPars.parsForBracket(StringCreater.userString());
                break;
            case "2":
                StringPars.parsForBracket(StringCreater.randomString());
                break;
            case "3":
                MainApp.choose();
                break;
        }
    }
}
