package ua.com.davidenko.app;

import ua.com.davidenko.lib.CrudService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserControl {

    public static void userControlChoose() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String crud;
        CrudService crudService;
        chooseCrudService();
        while ((crud = br.readLine()) != null) {
            switch (crud) {
                case "1":
                    crudService = createCrudService("ListCrudService");
                    break;
                case "2":
                    crudService = createCrudService("ObjectCrudService");
                    break;
                default:
                    System.out.println("Wrong input. Try again.");
                    continue;
            }
            userOperations(br, crudService);
            chooseCrudService();
        }
    }


    static void userOperations(BufferedReader br, CrudService crudService) throws IOException {
        String operation;
        chooseOperation();
        while ((operation = br.readLine()) != null) {
            switch (operation) {
                case "1":
                    User user = new User();
                    System.out.println("Enter the name: ");
                    user.setName(br.readLine());
                    System.out.println("Enter the age: ");
                    user.setAge(Integer.parseInt(br.readLine()));
                    crudService.create(user);
                    break;
                case "2":
                    crudService.read().forEach(System.out::println);
                    break;
                case "3":
                    System.out.println("Enter Id: ");
                    System.out.println(crudService.read(br.readLine()));
                    break;
                case "4":
                    System.out.println("Enter Id for update: ");
                    User newUser = (User) crudService.read(br.readLine());
                    System.out.println("Enter new name: ");
                    newUser.setName(br.readLine());
                    System.out.println("Enter new age: ");
                    newUser.setAge(Integer.parseInt(br.readLine()));
                    crudService.update(newUser);
                    break;
                case "5":
                    System.out.println("Enter Id for delete: ");
                    crudService.delete(br.readLine());
                    break;
                default:
                    System.out.println("Wrong choose");
                    continue;
            }
            chooseOperation();
        }
    }
    private static void chooseCrudService() {
        System.out.println("Choose CrudService operation type " +
                "\n 1 - List CrudService " +
                "\n 2 - Object[] CudService ");
    }
    private static void chooseOperation() {
        System.out.println("Choose operation: " +
                "\n 1 - Create, 2 - Read, 3 - Read by Id, 4 - Update, 5 - Delete ");
    }
    private static CrudService createCrudService(String crudName) {
        return new UserService(crudName);
    }
}



