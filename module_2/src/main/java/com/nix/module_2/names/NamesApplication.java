package com.nix.module_2.names;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NamesApplication {

    public static void run(){
        ArrayList<String> names = new ArrayList<>(Arrays.asList(
                "Vova", "Vasya", "Anatoliy",
                "Vova", "Vasya", "Petya",
                "Sanya", "Petya", "Petya"
        ));
        System.out.println("\n=====\nNames\n=====");
        System.out.println("All names:\n" + names);
        System.out.println("Unique name: " + findFirstUniqueName(names));
    }

    private static String findFirstUniqueName(ArrayList<String> names) {
        HashMap<String, Integer> namesMap = new HashMap<>();
        for (String name : names) {
            if (namesMap.containsKey(name))
                namesMap.put(name, namesMap.get(name) + 1);
            else
                namesMap.put(name, 1);
        }

        for (String name : names) {
            if (namesMap.get(name) == 1) {
                return name;
            }
        }

        return null;
    }
}
