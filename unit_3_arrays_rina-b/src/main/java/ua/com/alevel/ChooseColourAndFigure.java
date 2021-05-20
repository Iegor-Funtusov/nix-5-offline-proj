package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChooseColourAndFigure {

    static String yourColour;
    static String yourFigure;

    public static void chooseColourAndFigure() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose colour: \n" +
                "1 - white\n" +
                "2 - black\n");
        int colour = Integer.parseInt(reader.readLine());
        switch (colour) {
            case 1:
                yourColour = "WHITE";
                break;
            case 2:
                yourColour = "BLACK";
            default:
                System.out.println("Try again");
                break;
        }

        System.out.println(" Choose the figure\n" +
                           "1 King\n" +
                           "2 Queen\n" +
                           "3 Bishop\n" +
                           "4 Knight\n" +
                           "5 Rook\n" +
                           "6 Pawn\n");

        int choice = Integer.parseInt(reader.readLine());

        switch (choice) {
            case 1:
                yourFigure = "King";
                break;
            case 2:
                yourFigure = "Queen";
                break;
            case 3:
                yourFigure="Bishop";
                break;
            case 4:
                yourFigure="Knight";
                break;
            case 5:
                yourFigure="Rook";
                break;
            case 6:
                yourFigure="Pawn";
                break;
            default:
                System.out.println("Try again");
                break;
        }
        if (yourColour != null && yourFigure != null) {
            System.out.println("Your current figure: " + yourColour + " " + yourFigure);
        }
    }
}