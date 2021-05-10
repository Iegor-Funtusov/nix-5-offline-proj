package ua.com.alevel.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {

    public static void main(String[] args) {

        String implementation = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose service:");
        System.out.println("\"1\" - list, \"2\" - object");
        String strService = null;
        try {
            strService = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Choose number for 1 to 2");
            return;
        }
        switch (strService) {
            case "1": {
                implementation = "ListCrudService";
                break;}
            case "2": {
                implementation = "ObjectCrudService";
                break;}
        }
        UserService userService = new UserService(implementation);

        boolean isTrue = true;

        while (isTrue) {
            System.out.println("Choose action:");
            System.out.println("\"1\" - Create, \"2\" - Read, \"3\" - Update, \"4\" - Delete, \"5\" - Stop");

            String str = null;
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Choose number for 1 to 5");
                break;
            }
            switch (str) {
                case "1": {
                    System.out.println("Enter user name");
                    User user = new User();
                    try {
                        user.setName(reader.readLine());
                    } catch (IOException e) {
                        System.out.println("Name must be string");
                        e.printStackTrace();
                        break;
                    }

                    System.out.println("Enter user age");
                    try {
                        user.setAge(Integer.parseInt(reader.readLine()));
                    } catch (IOException e) {
                        System.out.println("Age must be int");
                        e.printStackTrace();
                        break;
                    }
                    userService.create(user);
                    break;
                }
                case "2": {
                    System.out.println(userService.read());
                    break;
                }
                case "3": {
                    System.out.println("Enter user id:");
                    String id = null;
                    try {
                        id = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Id must be int");
                        break;
                    }

                    User currentUser = userService.read(id);
                    if (currentUser == null) {
                        System.out.println("User not found");
                        break;
                    }

                    System.out.println("Enter user name");
                    try {
                        String name = reader.readLine();
                        currentUser.setName(name);
                    } catch (IOException e) {
                        System.out.println("Name must be string");
                        e.printStackTrace();
                        break;
                    }

                    System.out.println("Enter user age");
                    try {
                        int age = Integer.parseInt(reader.readLine());
                        currentUser.setAge(age);
                    } catch (IOException e) {
                        System.out.println("Age must be int");
                        e.printStackTrace();
                        break;
                    }

                    userService.update(currentUser);
                    break;
                }
                case "4": {
                    System.out.println("Enter user id:");
                    String id = null;
                    try {
                        id = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Id must be int");
                        break;
                    }
                    try {
                        userService.delete(id);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "5": {
                    isTrue = false;
                    break;
                }
            }
        }
    }
}
