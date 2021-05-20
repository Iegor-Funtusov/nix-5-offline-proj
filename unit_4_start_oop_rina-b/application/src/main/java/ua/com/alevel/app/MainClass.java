package ua.com.alevel.app;

import ua.com.alevel.lib.CrudFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MainClass {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[]args) throws IOException{
        int count;
        System.out.println("Add first user");
        Options.addUser();
        while (true) {
            System.out.println("Choose the option:\n" +
                    "1 Add user\n" +
                    "2 Show user by id\n" +
                    "3 Update user\n" +
                    "4 Remove user by id\n" +
                    "5 Show all users\n" +
                    "0 Exit");

            count = Integer.parseInt(reader.readLine());

            switch (count){
                case 1:
                    Options.addUser();
                    break;
                case 2:
                    Options.readById();
                    break;
                case 3:
                    Options.updateUser();
                    break;
                case 4:
                    Options.deleteUser();
                    break;
                case 5:
                    Options.readAll();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }

    }
}
