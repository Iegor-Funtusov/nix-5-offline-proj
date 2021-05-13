package org.example.app;

import org.example.lib.ListCrudService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

public class AppMain {
    public static void main(String[] args) throws IOException {
        UserService userService = new UserService();
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
        int choose = 0;

        while (true) {
            System.out.println("""
                Menu
                1. Add user
                2. Display all users
                3. Find user by id
                4. Update user
                5. Delete user by id""");

                choose = Integer.parseInt(enter.readLine());

            switch (choose) {
                case 1:
                    User user = new User();
                        System.out.println("Enter name: ");
                        user.setName(enter.readLine());
                        System.out.println("Enter age: ");
                        user.setAge(Integer.parseInt(enter.readLine()));
                    userService.create(user);
                    break;
                case 2:
                    System.out.println(userService.read().toString());
                    break;
                case 3:
                    System.out.println("Enter user id");
                    String id = enter.readLine();
                    System.out.println("Found user:" + userService.read(id));
                    break;
                case 4:
                    System.out.println("Enter user id");
                    id = enter.readLine();
                    User currentUser = userService.read(id);
                    if (currentUser != null) {
                        System.out.println("Enter new/old name");
                        String name = enter.readLine();
                        System.out.println("Enter new/old age");
                        int age = Integer.parseInt(enter.readLine());
                        currentUser.setAge(age);
                        currentUser.setName(name);
                        userService.update(currentUser);
                    }
                    break;
                case 5:
                    System.out.println("Enter user id");
                    id = enter.readLine();
                    userService.delete(id);
                    System.out.println("User is deleted");
            }

        }
    }
}
