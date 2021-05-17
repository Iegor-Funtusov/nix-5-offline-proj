package ua.com.alevel.first;

import ua.com.alevel.first.Knight;
import ua.com.alevel.MainApp;
import java.util.Scanner;
import java.util.Random;

public class Move {
    public static void run() {
        Knight knight = new Knight();
        Scanner s = MainApp.s;
        int x;
        int y;
        Random r = new Random();
        System.out.println("please enter the knight's coordinates");
        do {
            System.out.println("Manual input?(y/n)");
            if (s.next().toLowerCase().startsWith("y")) {
                x = s.nextInt();
                y = s.nextInt();
            } else {
                x = r.nextInt(knight.getY()+3);
                y = r.nextInt(knight.getX()+3);
            }if(knight.place(x, y))
                System.out.println("Knight placed on coordinates ");
            else{
                System.out.println("Knight couldn't be placed at ");
            }
            System.out.printf("(%d, %d)%n", x, y);
            System.out.println("Continue?(y/n)");
        }while(s.next().startsWith("y"));
    }

    public static String name(){
        return "Board";
    }
}
