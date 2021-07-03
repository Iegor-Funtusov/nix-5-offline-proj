package com.lapchenko.module.second.unique_name_finder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    private UniqueNameFinder nameFinder = new UniqueNameFinder();
    private String[] names = {"Rick", "Rick", "Jake", "Lina", "Jane", "Jane", "Rick", "Richard"};

    public void start() {
        String input = "";
        while(true) {
            printUserInterface();
            input = readUserInput();
            if(input.equals("1")) {
                readUserNames();
            }
            if(input.equals("2")) {
                readPreloadedNames();
            }
            if(input.equals("3")) {
                clear();
            }
            if(input.equals("4")) {
                printFirstUniqueName();
            }
            if(input.equals("0")) {
                break;
            }
        }
    }

    private void readUserNames() {
        String input = "";
        while (!input.equals("0")) {
            System.out.println("Enter name to add or 0 to stop entering: ");
            input = readUserInput();
            nameFinder.addName(input);
        }
    }

    private void readPreloadedNames() {
        for (int i = 0; i < names.length; i++) {
            nameFinder.addName(names[i]);
        }
    }

    private void clear() {
        try {
            nameFinder.clear();
        }catch (RuntimeException e) {
            System.out.println("Map is empty!");
        }
    }

    private void printFirstUniqueName() {
        try {
            System.out.println(nameFinder.findFirstUniqueName());
        }catch (RuntimeException e) {
            System.out.println("There is no unique name in map");
        }
    }

    private void printUserInterface() {
        System.out.println("" +
                "1 - To enter names\n" +
                "2 - To enter preloaded names\n" +
                "3 - Clear names map\n" +
                "4 - Print first unique name\n"+
                "0 - To exit");
    }

    private String readUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with console");
        }
    }
}
