package com.Lachenko_Kirill.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    private final BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    System.in));

    public void printPickYourColor() {
        System.out.println("Choose your color:\n" +
                "1 - For black\n" +
                "2 - For white");
    }

    public void printPickYourFigure() {
        System.out.println("Choose your figure:\n" +
                "1 - For pawn\n" +
                "2 - For knight\n" +
                "3 - For bishop\n" +
                "4 - For rook\n" +
                "5 - For Queen\n" +
                "6 - For King");
    }

    public void printChooseYourTile() {
        System.out.println(
                "Enter tile where you want to move your figure: "
        );
    }

    public int getUserInput() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public String getUserStringInput() throws IOException {
        return reader.readLine();
    }

    public String getColor() throws IOException {
        int userInput = getUserInput();
        if (userInput == 1)
            return "black";

        if (userInput == 2)
            return "white";
        throw new IllegalArgumentException("You can choose only between black and white color!!!");
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

    private void printExit() {
        System.out.println("If you want to exit type ex, or type any key to continue");
    }

    public boolean userWantsToExit() throws IOException {
        printExit();
        if (reader.readLine().equals("ex"))
            return true;
        return false;
    }


    public boolean userWantsToMoveFigureAgain() throws IOException {
        System.out.println("If you want to continue moving your figure enter 1");
        String userInput = getUserStringInput();
        if(userInput.equals("1"))
            return true;
        return false;
    }
}
