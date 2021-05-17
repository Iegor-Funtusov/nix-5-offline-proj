package level2;

import level1.Utils;

public class Main {
    public static void main() {

        boolean flag = true;

        do {

            Utils.clearConsole();
            System.out.println("\nLevel 2");
            System.out.println("\n1 - Check String" +
                               "\n2 - Move back\n");
            int choice = Utils.correctIntInput("Enter the number: ");

            switch (choice) {
                case 1:
                    StringCheckerApp.run();
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    Utils.clearConsole();
            }
        } while (flag);
    }
}
