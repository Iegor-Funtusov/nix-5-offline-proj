package ua.com.nix.task2;

import java.util.*;

public class UniqueName {

    public void run() {

        System.out.println("-------------WELCOME TO THE TASK 2 - SEARCHING AN UNIQUE NAME-------------");
        ArrayList<String> listOfNames = new ArrayList<>();
        listOfNames.add("Andrey");
        listOfNames.add("Artem");
        listOfNames.add("Evgeniy");
        listOfNames.add("Artem");
        listOfNames.add("Andrey");
        listOfNames.add("Obama");

        System.out.println("-------------INPUT STRINGS-------------");
        for (String listOfName : listOfNames) {
            System.out.println(listOfName);
        }

        System.out.println("-------------TASK 2 RESULT-------------");

        List<String> uniqueNames = new ArrayList<>(List.copyOf(listOfNames));
        for (String name : listOfNames) {
            uniqueNames.remove(name);
            if (!uniqueNames.contains(name)){
                System.out.println(name);
                return;
            }
        }

    }
}
