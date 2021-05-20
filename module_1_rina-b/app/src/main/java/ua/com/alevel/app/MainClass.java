package ua.com.alevel.app;
import ua.com.alevel.lvl1.*;
import ua.com.alevel.lvl2.StringCheck;
import ua.com.alevel.lvl3.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true){
            System.out.println("Choose level to check\n" +
                    "1 Level_1\n" +
                    "2 Level_2\n" +
                    "3 Level_3\n" +
                    "0 Exit");
            int choice = Integer.parseInt(reader.readLine());
            switch (choice){
                case 2:
                    Switcher.validityStringCheck();
                    break;
                case 3:
                    LifeGame.lifeGame();
                    break;
                case 0:
                    System.exit(0);
                case 1:
                    while (true) {
                        System.out.println("Choose the task:\n" +
                                "1 Unique Numbers\n" +
                                "2 Triangle Square\n" +
                                "3 Horse Move\n" +
                                "0 Exit\n");
                        int choose = Integer.parseInt(reader.readLine());
                        if (choose == 1) {
                            Switcher.uniqueNumberCount();
                        continue;
                        }
                        if (choose==2){
                            Switcher.triangleS();
                            continue;
                        }
                        if (choose == 3){
                            Switcher.chessHorseMove();
                            continue;
                        }
                        if (choose == 0){
                            break;
                        }
                    }
                    break;
            }
        }


    }
}