package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    public static int correctIntInput(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        while (true) {
            try {
                System.out.print(message);
                num = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException | NumberFormatException e) { }
        }
        return num;
    }

    public static float correctFloatInput(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float num;
        while (true) {
            try {
                System.out.print(message);
                num = Float.parseFloat(reader.readLine());
                break;
            } catch (IOException | NumberFormatException e) { }
        }
        return num;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean showStartMenu(String appName) {

        while(true) {

            clearConsole();
            System.out.println(appName);

            System.out.println("\n1 - Start\n" +
                    "2 - Exit");
            int choice = correctIntInput("\nEnter the number: ");

            switch (choice) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    clearConsole();
            }
        }
    }

    public static void pressEnter() {
        System.out.println("\nPress Enter to continue");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

}
