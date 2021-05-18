package ua.davidenko.level_1;

import ua.davidenko.level_1.task_1.MainTask_1;
import ua.davidenko.level_1.task_2.MainTask_2;
import ua.davidenko.level_1.task_3.MainTask_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level_1_Main {

    public static void level_1_Choose() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose task from 1 Level:");
        System.out.println("1 - Unique Symbol, 2 - Chess(Horse move), 3 - Triangle Area");
        String option = br.readLine();
        switch (option){
            case "1":
                MainTask_1.startArray();
            case "2":
                MainTask_2.startMove();
            case "3":
                MainTask_3.triangleStart();
        }
    }
}
