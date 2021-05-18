package ua.davidenko.leve_3.task_1;

import ua.davidenko.MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameMain {
    public static void chooseGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose Game: ");
        System.out.println("1 - Random Game,2 - user Game, 3 - return to LEVEL UP");
        String option = br.readLine();
        switch (option) {
            case "1":
                GameCreater.startRandomGame();
                break;
            case "2":
                break;
            case "3":
                MainApp.choose();
                break;
        }
    }
}




