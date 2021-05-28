package level2;

import level1.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCheckerApp {

    private static String string;
    private final static String appName = "\nString Checker";

    public static void run() {
        boolean flag = true;
        while (true) {
            flag = Utils.showStartMenu(appName);
            if (!flag)
                break;
            enterString();
            checkString();
        }
    }

    private static void enterString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Utils.clearConsole();
        System.out.println(appName);
        System.out.print("\nEnter string: ");
        try {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkString() {
        if (ValidStringChecker.checkString(string)) {
            System.out.println("\nEntered string is valid");
        } else {
            System.out.println("\nEntered string is invalid");
        }
        Utils.pressEnter();
    }

}
