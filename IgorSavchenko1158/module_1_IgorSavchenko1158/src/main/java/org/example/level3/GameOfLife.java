package org.example.level3;

import java.util.Random;

public class GameOfLife {

    private static final int BOARD_SIZE = 20;
    private static final char DEAD = '□';
    private static final char ALIVE = '■';

    // Suppose true = alive
    private boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];

    public static GameOfLife initRandom() {
        GameOfLife life = new GameOfLife();
        Random random = new Random();

        for (int i = 0; i < life.board.length; i++) {
            for (int j = 0; j < life.board.length; j++) {
                life.board[i][j] = random.nextBoolean();
            }
        }
        return life;
    }

    public static GameOfLife initGlider() {
        GameOfLife life = new GameOfLife();

        life.board[5][5] = true; //TODO
        life.board[6][5] = true;
        life.board[7][5] = true;
        life.board[5][6] = true;
        life.board[6][7] = true;

        return life;
    }

    public void progressToNextGen() {
        final boolean[][] nextGenBoard = new boolean[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                int count = countNeighbors(i, j);
                if (board[i][j]) {
                    nextGenBoard[i][j] = count >= 2 && count <= 3;
                } else if (count == 3) {
                    nextGenBoard[i][j] = true;
                }
            }
        }
        board = nextGenBoard;
    }

    private int countNeighbors(int i, int j) {
        int count = 0;
        for (int i1 = i - 1; i1 <= i + 1; i1++) {
            for (int j1 = j - 1; j1 <= j + 1; j1++) {
                if (i1 == i && j1 == j) continue;
                if (board[wrap(i1)][wrap(j1)]) {
                    count++;
                }
            }
        }

        return count;
    }

    private int wrap(int coordinate) {
        int result = coordinate;
        if (coordinate < 0) {
            result = BOARD_SIZE + coordinate;
        } else if (coordinate >= BOARD_SIZE) {
            result = coordinate - BOARD_SIZE;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append(i).append('\t');
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j]) {
                    sb.append(ALIVE);
                } else {
                    sb.append(DEAD);
                }
                sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
