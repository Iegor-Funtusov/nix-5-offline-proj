package ua.practice.unit4.app;

import ua.practice.unit4.lib.CrudService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        CrudService crudService;
        chooseCrudService();
        while ((string = bufferedReader.readLine()) != null) {
            switch (string) {
                case "1":
                    crudService = createCrud("ListCrudService");
                    break;
                case "2":
                    crudService = createCrud("ArrayCrudService");
                    break;
                case "3":
                    return;
                default:
                    continue;
            }
            doOption(bufferedReader, crudService);
            chooseCrudService();
        }
    }

    static CrudService createCrud(String implementationName) {
        return new UserService(implementationName);
    }

    static void doOption(BufferedReader bufferedReader, CrudService crudService) throws IOException {
        String str;
        chooseOperation();
        while ((str = bufferedReader.readLine()) != null) {
            switch (str) {
                case "1":
                    User user = new User();
                    user.setName(bufferedReader.readLine());
                    user.setAge(Integer.parseInt(bufferedReader.readLine()));
                    crudService.create(user);
                    break;
                case "2":
                    crudService.read().forEach(System.out::println);
                    break;
                case "3":
                    System.out.println(crudService.read(bufferedReader.readLine()));
                    break;
                case "4":
                    User user1 = (User) crudService.read(bufferedReader.readLine());
                    user1.setName(bufferedReader.readLine());
                    user1.setAge(Integer.parseInt(bufferedReader.readLine()));
                    crudService.update(user1);
                    break;
                case "5":
                    crudService.delete(bufferedReader.readLine());
                    break;
                case "6":
                    return;
            }
            chooseOperation();
        }
    }

    static void chooseOperation() {
        System.out.println("Choose option:");
        System.out.println("1 - Create");
        System.out.println("2 - Read all");
        System.out.println("3 - Read by Id");
        System.out.println("4 - Update");
        System.out.println("5 - Delete");
        System.out.println("6 - Stop");
    }

    static void chooseCrudService() {
        System.out.println("Choose crud service type implementation");
        System.out.println("1 - List Service");
        System.out.println("2 - Array Service");
        System.out.println("3 - Stop");
    }
}
