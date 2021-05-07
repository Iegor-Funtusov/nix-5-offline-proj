package org.example.app;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {

        DogService dogService = new DogService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select action: \n" +
                    "1  View database \n" +
                    "2  Add new dog \n" +
                    "3  Edit dog's name by id \n" +
                    "4  Edit dog's breed by id \n" +
                    "5  Delete dog by id \n" +
                    "Any other input to exit");

            switch (scanner.next()) {
                case "1": {
                    System.out.println(dogService.read());
                    break;
                }
                case "2": {
                    System.out.println("Enter dog's name and breed separated by space");
                    Dog newDog = new Dog().setName(scanner.next()).setBreed(scanner.next());
                    dogService.create(newDog);
                    break;
                }
                case "3": {
                    System.out.println("Enter dog's ID:");
                    String id = scanner.next();
                    Dog currentDog;
                    if ((currentDog = dogService.read(id)) == null) {
                        System.out.println("Wrong id");
                        break;
                    }
                    System.out.println("Enter new name:");
                    dogService.update(currentDog.setName(scanner.next()));
                    break;
                }
                case "4": {
                    System.out.println("Enter dog's ID:");
                    String id = scanner.next();
                    Dog currentDog;
                    if ((currentDog = dogService.read(id)) == null) {
                        System.out.println("Wrong id");
                        break;
                    }
                    System.out.println("Enter new breed:");
                    dogService.update(currentDog.setBreed(scanner.next()));
                    break;
                }
                case "5": {
                    System.out.println("Enter dog's ID:");
                    try {
                        dogService.delete(scanner.next());
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                }
                default:
                    System.exit(0);
            }

            scanner.nextLine();
        }
    }
}
