package ua.com.alevel;

import ua.com.alevel.first.Move;
import ua.com.alevel.first.UniqueSymbol;

import java.util.Scanner;

public class MainApp {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("Please choose task level(1-3)");
            System.out.println("""
                    1.1)Print unique nums
                      2)Chess
                      3)Triangle square
                    2.String check
                    """);
            int level = s.nextInt();
            int number;
            switch (level) {
                case 1: {
                    System.out.println("Please select task:");
                   number = s.nextInt();
                }
                break;
                case 2: {
                    number = 4;
                }
                break;
                case 3: {
                    number = 5;
                }
                break;
                default:
                   number= 5;
            }
            chooselevel(number);
            System.out.println("Check another task?(y/n)");
        } while (s.next().toLowerCase().startsWith("y"));
    }
    public static void chooselevel(int number) {
        System.out.println("So you have chosen ");
        switch (number) {
            case 1: {
                System.out.println(UniqueSymbol.name());
                UniqueSymbol.solve();
            }

            case 2:{
                System.out.println(Move.name());
                Move.run();
            }

            break;




        }
    }


}
