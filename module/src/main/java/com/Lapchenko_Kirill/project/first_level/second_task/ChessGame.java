package com.Lapchenko_Kirill.project.first_level.second_task;

import java.io.IOException;

public class ChessGame {
    private final ChessUI userInterface = new ChessUI();

    public void play() throws IOException {
        String color = "";
        int figure = 0;
        int posX = 0;
        int posY = 0;
        int moveX = 0;
        int moveY = 0;
        userInterface.printChooseRaw();
        posY = userInterface.getUserInput();
        userInterface.printChooseColumn();
        posX = ChessBoard.getNumericEquivalent(userInterface.getUserStringInput());
        userInterface.printChooseRaw();
        moveY = userInterface.getUserInput();
        userInterface.printChooseColumnToMove();
        moveX = ChessBoard.getNumericEquivalent(userInterface.getUserStringInput());
        if (knightMove(posX, posY, moveX, moveY))
            System.out.println("Move is possible");
        else
            System.out.println("Impossible move!");
    }

    private boolean knightMove(int xBegin, int yBegin, int x, int y) {
        if ((Math.abs(xBegin - x) == 1) && (Math.abs(yBegin - y) == 2)) {
            return true;
        }
        if ((Math.abs(xBegin - x) == 2) && (Math.abs(yBegin - y) == 1)) {
            return true;
        }
        return false;
    }
}

