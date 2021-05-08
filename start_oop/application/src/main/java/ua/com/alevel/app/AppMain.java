package ua.com.alevel.app;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {

    public static void main(String[] args) throws IOException {
        System.out.println("AppMain.main");

        UserService userService = new UserService();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        int age;

        ExitLabel:
        while (true) {
            System.out.println("1(Create),2(Read),3(Update),4(Delete),5(Exit)");
            String s = reader.readLine();
            switch (s) {
                case "1": {
                    System.out.println("Enter user's name and age");
                    User user = new User().setName(reader.readLine()).setAge(Integer.parseInt(reader.readLine()));
                    userService.create(user);
                    break;
                }
                case "2": {
                    System.out.println(userService.read());
                    break;
                }
                case "3": {
                    System.out.println("Enter ID for update:");
                    String id = reader.readLine();
                    User currentUser;
                    if ((currentUser = userService.read(id)) == null) {
                        System.out.println("Doesn't exist ID");
                        break;
                    }
                    System.out.println("Enter new name and age:");
                    userService.update(currentUser.setName(reader.readLine()).setAge(Integer.parseInt(reader.readLine())));
                    break;
                }
                case "4": {
                    System.out.println("Enter ID for delete:");
                    try {
                        userService.delete(reader.readLine());
                    } catch (RuntimeException ex) {
                        System.out.println("Maybe it's problem of: "+ ex.getMessage());
                    }
                    break;
                }
                case "5": {
                        break ExitLabel;
                }
            }
        }
    }
}