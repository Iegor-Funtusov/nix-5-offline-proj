package level3;

import level1.Utils;

public class Main {
    public static void main() {

        boolean flag = true;

        do {

            Utils.clearConsole();
            System.out.println("\nLevel 3");
            System.out.println("\n1 - Game of Life" +
                               "\n2 - Move back\n");
            int choice = Utils.correctIntInput("Enter the number: ");

            switch (choice) {
                case 1:
                    GameOfLife.run();
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
