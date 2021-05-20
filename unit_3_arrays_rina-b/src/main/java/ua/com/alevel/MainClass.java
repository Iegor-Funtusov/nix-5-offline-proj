package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class MainClass {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[]args) throws IOException {
        while (true){
            Start();
            System.out.println("You could move your figure");
            ChessMove.chessMove();
            Choice();
        }
    }



    private static void Start() throws IOException {
        while (true) {
            ChooseColourAndFigure.chooseColourAndFigure();
            if (ChooseColourAndFigure.yourFigure != null && ChooseColourAndFigure.yourColour != null) {
                ChessMove.chessMove();
            } else {
                continue;
            }
            break;

        }

    }
    private static void Choice() throws IOException {
        while (true){
            System.out.println("Select next step:\n" +
                    "1 Move figure\n" +
                    "2 Start again\n" +
                    "0 Exit");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    ChessMove.chessMove();
                    break;
                case 2:
                    Start();
                    break;
            }
        }
    }
}
