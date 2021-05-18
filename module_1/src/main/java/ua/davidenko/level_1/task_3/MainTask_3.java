package ua.davidenko.level_1.task_3;

import ua.davidenko.MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask_3 {
   public static void triangleStart() throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Choose Triangle creater:\n1 - user creater, 2 - random creater  ");
       System.out.println("3 - return to LEVEL UP");
       String option = br.readLine();
       switch (option){
           case "1":
               TriangleCreater.UserTriangle();
               break;
           case "2":
               TriangleCreater.randomTriengle();
               break;
           case "3":
               MainApp.choose();
               break;
       }

    }
}
