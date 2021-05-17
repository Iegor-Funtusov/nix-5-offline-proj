import level1.Utils;

public class Main {
    public static void main(String[] args) {
        do {

            Utils.clearConsole();

            System.out.println("\n1 - Level 1" +
                               "\n2 - Level 2" +
                               "\n3 - Level 3" +
                               "\n4 - Exit\n");
            int choice = Utils.correctIntInput("Enter the number: ");

            switch (choice) {
                case 1:
                    level1.Main.main();
                    break;
                case 2:
                    level2.Main.main();
                    break;
                case 3:
                    level3.Main.main();
                    break;
                case 4:
                    System.exit(0);
                default:
                    Utils.clearConsole();
            }
        } while (true);
    }
}
