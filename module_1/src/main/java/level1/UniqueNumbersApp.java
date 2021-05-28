package level1;

public class UniqueNumbersApp {

    private static final String appName = "\nUnique Numbers";
    private static int[] arr;

    public static void run() {
        boolean flag = true;
        while (true) {
            flag = Utils.showStartMenu(appName);
            if (!flag)
                break;
            createArray();
            showUniqueElementsNumber();
        }
    }

    private static void createArray() {
        Utils.clearConsole();
        System.out.println(appName);
        System.out.println("\nCreate int array\n----------------\n");
        int arrLength = Utils.correctIntInput("Enter arr length: ");
        arr = new int[arrLength];
        System.out.println();
        for (int i = 0; i < arrLength; i++) {
            arr[i] = Utils.correctIntInput("arr[" + i + "]: ");
        }
    }

    private static void showUniqueElementsNumber() {
        Utils.clearConsole();
        System.out.println(appName);
        System.out.println("\nNumber of unique elements: " + UniqueNumbersCounter.count(arr));
        Utils.pressEnter();
    }

}
