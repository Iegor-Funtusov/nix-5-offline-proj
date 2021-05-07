package ua.com.alevel.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SOLID
public class AppMain {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        UserService userService = new UserService();

        while (true) {
            System.out.println("Operations in order: 1 - Create 2 - Read 3 - Update 4 - Delete 5 - Exit");
            System.out.println("Write username and age:");
            User user = new User().setName(reader.readLine()).setAge(Integer.parseInt(reader.readLine()));
            userService.create(user);
            System.out.println(userService.read());

            System.out.println("Enter ID: ");
            String id = reader.readLine();
            User currentUser;
            if ((currentUser = userService.read(id)) == null) {
                System.out.println("ID doesn't exist.");
            }
            System.out.println("Type new name and age: ");
            assert currentUser != null;
            userService.update(currentUser.setName(reader.readLine()).setAge(Integer.parseInt(reader.readLine())));

            System.out.println("Enter ID for delete: ");
            try {
                userService.delete(reader.readLine());
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
            break;
        }

    }

}

