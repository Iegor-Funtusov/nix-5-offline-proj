package main.java.com.example.unit1.controller;

import com.google.gson.Gson;
import main.java.com.example.unit1.model.User;
import main.java.com.example.unit1.service.UserService;
import main.java.com.example.unit1.service.UserServiceImpl;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UserController {

    private final UserService userService = new UserServiceImpl();
    private final Gson gson = new Gson();

    public void exec(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            String read;
            String helpStr = "Set an action: " +"\n 1 - insert User" +"\n 2 - update User"
                    + "\n 3 - delete User" + "\n 4 - get all users" + "\n 0 - exit";
            System.out.println(StringUtils.upperCase(helpStr));
            while((read = in.readLine()) != null){
                switch (read) {
                    case "1":{
                        createUser(in);
                    } break;
                    case "2":{
                        updateUser(in);
                    } break;
                    case "3":{
                        deleteUserById(in);
                    } break;
                    case "4":{
                        getAllUsersAndPrint();
                    } break;
                    case "0":{
                        System.exit(0);
                    } break;
                }
                System.out.println("Continue.. You can select action again");
            }
        } catch (IOException ex){
            System.out.println("IOException from exec() reader: " + ex.getMessage());
        }

    }

    private void createUser(BufferedReader reader) throws IOException {
        User user = new User();
        System.out.println("Enter first name of user: ");
        user.setFirstName(reader.readLine());
        System.out.println("Enter last name of user: ");
        user.setLastName(reader.readLine());
        userService.create(user);
    }

    private void updateUser(BufferedReader reader) throws IOException {
        User user = new User();
        System.out.println("Enter Id of user which you want to change: ");
        user.setId(reader.readLine());
        System.out.println("Enter first name of user: ");
        user.setFirstName(reader.readLine());
        System.out.println("Enter last name of user: ");
        user.setLastName(reader.readLine());
        userService.update(user);
    }
    private void deleteUserById(BufferedReader reader) throws IOException {
        System.out.println("Enter Id of user which you want to Delete: ");
        String id = reader.readLine();
        userService.deleteById(id);
    }
    private void getAllUsersAndPrint() {
        List<User> users = userService.getAllUsers();
        String usersJson = gson.toJson(users);
        System.out.println(usersJson);
    }

}
