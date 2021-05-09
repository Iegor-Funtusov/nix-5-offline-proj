package ua.com.alevel.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {

    public static void main(String[] args) throws IOException {
        UserService userService = new UserService();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.print("1.Create user\n2.Read user\n3.Update user\n4.Delete user\nEnter the operation number: ");
            int operation = Integer.parseInt(bufferedReader.readLine());

            switch (operation) {
                case 1:
                    User user = new User();
                    System.out.print("Enter Username: ");
                    user.setName(bufferedReader.readLine());

                    System.out.print("Enter user Age: ");
                    user.setAge(Integer.parseInt(bufferedReader.readLine()));

                    userService.create(user);
                    break;
                case 2:
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    userService.read().forEach(System.out::println);
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    String id = bufferedReader.readLine();
                    User currentUser = userService.read(id);
                    if (currentUser != null) {
                        System.out.print("Enter new Username: ");
                        String name = bufferedReader.readLine();
                        currentUser.setName(name);

                        System.out.print("Enter new user Age: ");
                        int age = Integer.parseInt(bufferedReader.readLine());
                        currentUser.setAge(age);

                        userService.update(currentUser);
                    }
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    id = bufferedReader.readLine();

                    userService.delete(id);
                    System.out.println("User deleted successfully!");
            }
        }
    }
}
