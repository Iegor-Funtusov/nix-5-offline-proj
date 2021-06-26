package com.lapchenko.project.app;

import com.lapchenko.project.lib.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathSetUIInteger {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private MathSet<Integer> mathSet = new MathSet<>();

    public void start() {
        while (true)
            chooseMethod();
    }

    private void chooseMethod() {
        printMenu();
        System.out.print("Your input >");
        int userInput = getUserInt();
        switch (userInput) {
            case 1:
                createMathSet();
                break;
            case 2:
                add();
                break;
            case 3:
                getAvgMinMaxMed();
                break;
            case 4:
                sort();
                break;
            case 5:
                squash();
                break;
            case 6:
                print();
                break;
            case 7:
                clear();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }

    private void printMenu() {
        System.out.println("" +
                "1 - Set size of MathSet (recreates set)\n" +
                "2 - Add\n" +
                "3 - Get avg\\min\\max\\med\n" +
                "4 - Sort\n" +
                "5 - Squash\n" +
                "6 - Print MathSet\n" +
                "7 - Clear\n" +
                "8 - Exit\n");
    }

    private void createMathSet() {
        System.out.print("Please set size of set >");
        mathSet = new MathSet(getUserInt());
    }

    private void add() {
        System.out.println("" +
                "1 - To add one number to set\n" +
                "2 - To add multiple numbers to set");
        int userInput = getUserInt();
        if(userInput == 1) {
            System.out.print("Enter value >");
            mathSet.add(getUserInt());
        }else if(userInput == 2) {
            System.out.print("Enter how much numbers do you want to add >");
            int amountOfNumbers = getUserInt();
            for (int i = 0; i < amountOfNumbers; i++) {
                System.out.print("Enter value >");
                mathSet.add(getUserInt());
            }
        }
    }

    private void getAvgMinMaxMed() {
        System.out.println(""
                + "Avg value >" + mathSet.getAverage() + "\n"
                + "Min value >" + mathSet.getMin() + "\n"
                + "Max value >" + mathSet.getMax() + "\n"
                + "Median value >" + mathSet.getMedian()
        );
    }

    private void sort() {
        System.out.println("" +
                "1 - To sort whole set\n" +
                "2 - To sort with bounds\n");
        int userInput = getUserInt();
        if(userInput == 1){
            sortWhole();
        }
        if(userInput == 2){
            sortWithBounds();
        }
    }

    private void sortWhole() {
        System.out.println("" +
                "1 - To sort asc\n" +
                "2 - To sort desc\n");
        int userInput = getUserInt();
        if(userInput == 1) {
            mathSet.sort(true);
            return;
        }
        if(userInput == 2) {
            mathSet.sort(false);
            return;
        }
        System.out.println("Wrong input, going back to main menu!");
    }

    private void sortWithBounds() {
        int leftBound, rightBound;
        System.out.print("Enter leftBound >");
        leftBound = getUserInt();
        System.out.print("Enter rightBound >");
        rightBound = getUserInt();

        System.out.println("" +
                "1 - To sort asc\n" +
                "2 - To sort desc\n");
        int userInput = getUserInt();
        try{
            if(userInput == 1) {
                mathSet.sort(leftBound, rightBound, true);
                return;
            }
            if(userInput == 2) {
                mathSet.sort(leftBound, rightBound,false);
                return;
            }
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong bounds!");
            return;
        }
        System.out.println("Wrong input, going back to main menu!");
    }

    private void squash() {
        int leftBound, rightBound;
        System.out.print("Enter leftBound >");
        leftBound = getUserInt();
        System.out.print("Enter rightBound >");
        rightBound = getUserInt();

        try{
            System.out.println(mathSet.squash(leftBound, rightBound));
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong bounds!");
            return;
        }
    }

    private void print() {
        System.out.println(mathSet);
    }

    private void clear() {
        System.out.println("" +
                "1 - To clear whole set\n" +
                "2 - To remove certain numbers\n");
        int userInput = getUserInt();
        if(userInput == 1) {
            clearWhole();
            return;
        }
        if(userInput == 2) {
            clearNumbers();
            return;
        }
        System.out.println("Wrong input going back to menu!");
    }

    private void clearNumbers() {
        System.out.print("Enter how much numbers do you want to delete >");
        int amountOfNumbers = getUserInt();
        Integer[] temp = new Integer[amountOfNumbers];
        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.print("Enter value >");
            temp[i] = getUserInt();
        }
        mathSet.clear(temp);
    }

    private void clearWhole() {
        mathSet.clear();
    }

    private static Integer getUserInt() {
        String regex = "[0-9]+";
        try {
            String userInput = reader.readLine();
            if(userInput.matches(regex)){
                return Integer.parseInt(userInput);
            }else {
                System.out.println("Wrong input, try again");
                return getUserInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something went wrong in getUserInt() method");
    }
}
