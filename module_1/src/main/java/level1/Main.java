package level1;

public class Main {
    public static void main() {

        boolean flag = true;

        do {

            Utils.clearConsole();
            System.out.println("\nLevel 1");
            System.out.println("\n1 - Unique Numbers" +
                    "\n2 - Knight Move" +
                    "\n3 - Triangle Square" +
                    "\n4 - Move back");
            int choice = Utils.correctIntInput("\nEnter the number: ");

            switch (choice) {
                case 1:
                    UniqueNumbersApp.run();
                    break;
                case 2:
                    KnightMoveApp.run();
                    break;
                case 3:
                    TriangleSquareApp.run();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    Utils.clearConsole();
            }
        } while (flag);
    }
}
