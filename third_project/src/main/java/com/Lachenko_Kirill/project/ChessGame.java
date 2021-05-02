package com.Lachenko_Kirill.project;

import java.io.IOException;

public class ChessGame {
    private final UserInterface userInterface = new UserInterface();
    public void play() throws IOException {
        String color = "";
        int figure = 0;
        int posX = 0;
        int posY = 0;
        ChessFigure playersFigure;
        while (true) {
            if(userInterface.userWantsToExit())
                break;
            userInterface.printPickYourColor();
            color = userInterface.getColor();
            userInterface.printPickYourFigure();
            figure = userInterface.getUserInput();
            userInterface.printChooseRaw();
            posY = userInterface.getUserInput();
            userInterface.printChooseColumn();
            posX = ChessBoard.getNumericEquivalent(userInterface.getUserStringInput());
            playersFigure = new ChessFigure(posX, posY, color, figure);
            TypeCoordinatesAgain:
            while (true) {
                userInterface.printChooseRawToMove();
                posY = userInterface.getUserInput();
                userInterface.printChooseColumnToMove();
                posX = ChessBoard.getNumericEquivalent(userInterface.getUserStringInput());
                if (playersFigure.makeMove(posX, posY)) {
                    System.out.println("Your figure now at " + posY + " " + ChessBoard.getLetterEquivalent(posX - 1));
                    if(!userInterface.userWantsToMoveFigureAgain())
                        break;
                } else {
                    System.out.println("Try again, wrong coordinates");
                    continue TypeCoordinatesAgain;
                }
            }

        }
    }
}
