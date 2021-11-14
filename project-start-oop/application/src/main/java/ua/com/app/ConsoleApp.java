package ua.com.app;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleApp {

    private static final BufferedReader bufferedReader;
    private static final UserService userService;
    private static User temporaryUser;

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        userService = new UserService();
    }

    @SneakyThrows
    public static void main(String[] args) {
        ConsoleApp consoleApp = new ConsoleApp();
        System.out.println("Hello everybody!");
        while (true) {
            System.out.println("Please, choose the operation: ");
            consoleApp.chooseMessage();
            String x = bufferedReader.readLine();
            switch (x) {
                case "1": {
                    consoleApp.addUser();
                    break;
                }
                case "2": {
                    consoleApp.readUser();
                    break;
                }
                case "3": {
                    consoleApp.updateUser();
                    break;
                }
                case "4":{
                    consoleApp.deleteUser();
                    break;
                }
                case "5":{
                    consoleApp.userReadAll();
                    break;
                }
                case "0":{
                    System.exit(0);
                    break;
                }
            }
            System.out.print("\nThe current status of users: ");
            consoleApp.userReadAll();
            System.out.println();
        }
    }

    private void deleteUser(){
        String id = inputId();
        if(userService.read(id)==null){
            System.out.println("Entity doesn't exist");
        }else{
            userService.delete(id);
        }
    }

    @SneakyThrows
    private String inputId(){
        System.out.print("Write a user id: ");
        return bufferedReader.readLine();
    }

    private void userReadAll(){
        String output = userService.readAll().toString();
        if(output.equals("[]")){
            System.out.println("Users doesn't exist");
        }else{
        System.out.println(output);
        }
    }

    @SneakyThrows
    private void updateUser(){
        String id = inputId();
        if(userService.read(id)==null){
            System.out.println("Entity doesn't exist");
        }else{
        temporaryUser = userService.read(id);
        updateUser(inputName(), inputAge());
        }
    }

    @SneakyThrows
    private void addUser(){
        createUser(inputName(), inputAge());
    }

    @SneakyThrows
    private void readUser(){
        String id = inputId();
        if(userService.read(id)==null){
            System.out.println("Entity doesn't exist");
        }else{
        System.out.println(userService.read(id));
        }
    }

    private void createUser(String name, Integer age) {
        temporaryUser = new User();
        temporaryUser.setName(name);
        temporaryUser.setAge(age);
        userService.create(temporaryUser);
    }

    private void updateUser(String name, Integer age){
        temporaryUser.setName(name);
        temporaryUser.setAge(age);
        userService.update(temporaryUser);
    }

    private void chooseMessage() {
        System.out.println("1 - Create User");
        System.out.println("2 - Read User by id");
        System.out.println("3 - Update User");
        System.out.println("4 - Delete User by id");
        System.out.println("5 - Read all users");
        System.out.println("0 - Exit");
    }

    @SneakyThrows
    private String inputName(){
        String name;
        do {
            System.out.print("Write a name: ");
            name = bufferedReader.readLine();
        } while (!name.matches("^[A-Z]*[a-z]+"));
        return name;
    }

    @SneakyThrows
    private int inputAge(){
        String age;
        do {
            System.out.print("Write a age: ");
            age = bufferedReader.readLine();
        } while (!age.matches("[0-9]+"));
        return Integer.parseInt(age);
    }


    }

