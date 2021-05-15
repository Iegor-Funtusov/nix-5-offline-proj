package ua.com.alevel.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AppMain {
    private static LaptopService laptopService = new LaptopService();

    public static void main(String[] args) {

        String message = "\nChoose operation:\n\n" +
                "1 - create\n" +
                "2 - delete\n" +
                "3 - update\n" +
                "4 - read object\n" +
                "5 - read all\n" +
                "6 - exit\n" +
                "\nEnter the number: ";

        while (true) {

            int choice = correctIntInput(message);

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    readObject();
                    break;
                case 5:
                    readAll();
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }

    private static void create() {
        Laptop laptop = new Laptop();
        laptop.setLaptopMemory(correctIntInput("\nCreating\nLaptop memory: "));
        laptopService.create(laptop);
    }

    private static void delete() {
        laptopService.delete(correctIdInput("\nDeleting"));
    }

    private static void update() {
        Laptop laptop = laptopService.read(correctIdInput("\nUpdating"));
        laptop.setLaptopMemory(correctIntInput("\nMemory in gb: "));
        laptopService.update(laptop);
    }

    private static void readObject() {
        System.out.println("\n" + laptopService.read(correctIdInput("\nReading")).toString());
    }

    private static void readAll() {
        System.out.println("\nRead all\n");
        for (Laptop laptop : laptopService.read()) {
            System.out.println(laptop);
        }
    }

    private static String correctIdInput(String message) {
        message = message + "\nEnter object's id: ";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print(message);
            try {
                String inputId = reader.readLine();
                if (laptopService.read().stream().anyMatch(v -> v.getId().equals(inputId))) {
                    return inputId;
                }
            } catch (IOException e) {}
        }
    }

    private static int correctIntInput(String message) {
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
}
