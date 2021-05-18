package com.Lapchenko_Kirill.project.first_level.second_task;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessUI {

    private final BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    System.in));


    public void printChooseYourTile() {
        System.out.println(
                "Enter tile where you want to move your figure: "
        );
    }

    public int getUserInput() throws IOException {
        String userInput = reader.readLine();
        String regex = "\\d+";
        if (userInput.matches(regex))
            return Integer.parseInt(userInput);
        System.out.println("Wrong input try again!");
        return getUserInput();
    }

    public String getUserStringInput() throws IOException {
        String userInput = reader.readLine();
        String regex = "[ABCDEFGHabcdefgh]";
        if (userInput.matches(regex))
            return userInput;
        System.out.println("Wrong input try again!");
        return getUserStringInput();
    }

    public void printChooseRaw() {
        System.out.println("Choose number of tile where you want to place your figure from 1 - 8");
    }

    public void printChooseRawToMove() {
        System.out.println("Choose number of tile where you want to move your figure from 1 - 8");
    }


    public void printChooseColumnToMove() {
        System.out.println("Choose letter of tile where you want to move your figure from a - h");
    }

    public void printChooseColumn() {
        System.out.println("Choose letter of tile where you want to place your figure from a - h");
    }

}

