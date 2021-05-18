package com.Lapchenko_Kirill.project.third_level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class LifeGame {
    private int length = 10, width = 10;
    private boolean[][] lifeGameBoard = new boolean[length][width];

    public void printField() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (lifeGameBoard[i][j] == false) {
                    System.out.print("( )");
                } else
                    System.out.print("(o)");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void fillFieldRand() {
        length = new Random().nextInt(10) + 5;
        width = new Random().nextInt(10) + 5;
        lifeGameBoard = new boolean[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                lifeGameBoard[i][j] = new Random().nextBoolean();
            }
        }
        printField();
    }

    public void askUserFillField() throws IOException {
        System.out.println("Enter length of field ");
        length = Integer.parseInt(getUserInput("[0-9]+"));
        System.out.println("Enter width of field ");
        width = Integer.parseInt(getUserInput("[0-9]+"));
        lifeGameBoard = new boolean[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println("Cell " + i + " " + j + " enter 1 if alive or 0 if dead");
                lifeGameBoard[i][j] = getUserInput("[01]").equals("1");
            }
        }
        printField();
    }

    private String getUserInput(String regex) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        if (userInput.matches(regex)) {
            return userInput;
        } else {
            System.out.printf("Wrong input try again!");
            return getUserInput(regex);
        }
    }

    public void nextGeneration() {
        boolean[][] nextGeneration = new boolean[length][width];
        for (int x = 1; x < length - 1; x++) {
            for (int y = 1; y < width - 1; y++) {
                int neighboursCount = countNeighbours(x, y);
                neighboursCount -= lifeGameBoard[x][y] ? 1 : 0;
                if ((lifeGameBoard[x][y]) && (neighboursCount < 2)) {
                    nextGeneration[x][y] = false;
                } else if ((lifeGameBoard[x][y]) && (neighboursCount > 3)) {
                    nextGeneration[x][y] = false;
                } else if ((!lifeGameBoard[x][y]) && (neighboursCount == 3)) {
                    nextGeneration[x][y] = true;
                } else {
                    nextGeneration[x][y] = lifeGameBoard[x][y];
                }
            }
        }
        lifeGameBoard = nextGeneration;
    }

    private int countNeighbours(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (lifeGameBoard[x + i][y + j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
