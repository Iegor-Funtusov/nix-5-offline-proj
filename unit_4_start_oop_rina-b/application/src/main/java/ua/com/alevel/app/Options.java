package ua.com.alevel.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Options {
    static UserService userService = new UserService();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void addUser() throws IOException{
        User user = new User();
        System.out.println("Enter your name");
        user.setName(reader.readLine());
        System.out.println("Enter your age");
        user.setAge(Integer.parseInt(reader.readLine()));
        userService.create(user);

    }

    public static void readById() throws IOException{
        System.out.println("Enter your id");
        String id = reader.readLine();
        System.out.println( userService.read(id));
        System.out.println("Operation complete");
    }

    public static void updateUser() throws IOException{
        System.out.println("Enter your id");
        String id = reader.readLine();
        User currentUser = userService.read(id);
        if (currentUser != null) {
            System.out.println("Enter name");
            String name = reader.readLine();
            System.out.println("Enter age");
            int age = Integer.parseInt(reader.readLine());
            currentUser.setAge(age);
            currentUser.setName(name);
            userService.update(currentUser);
            System.out.println("Operation complete");
        }
    }
    public static void deleteUser() throws IOException{
        System.out.println("Enter your id");
        String id = reader.readLine();
        userService.delete(id);
        System.out.println("Operation complete");
    }
    public static void readAll() throws IOException{
        System.out.println(userService.read().toString());
    }
}

