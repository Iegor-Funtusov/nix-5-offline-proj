package ua.practice.module1.level3;

import org.apache.commons.lang3.ArrayUtils;

public class GameOfLife {
    private final int boardLength;
    private final int boardHeight;
    private int[][] board;

    public GameOfLife(int boardLength, int boardHeight) {
        this.boardLength = boardLength;
        this.boardHeight = boardHeight;
        board = new int[boardLength][boardHeight];
    }

    public boolean setAlive(int posX, int posY) {
        if (posX < 0 || posX >= boardLength) return false;
        if (posY < 0 || posY >= boardHeight) return false;
        board[posX][posY] = 1;
        return true;
    }

    private void setAliveTempBoard(int posX, int posY, int[][] board) {
        board[posX][posY] = 1;
    }

    private void setDeadTempBoard(int posX, int posY, int[][] board) {
        board[posX][posY] = 0;
    }

    public int isAlive(int posX, int posY) {
        if (posX < 0 || posX >= boardLength) return 0;
        if (posY < 0 || posY >= boardHeight) return 0;
        return board[posX][posY];
    }

    public int countOfAliveNeighbors(int posX, int posY) {
        int counter = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                counter += isAlive(posX + i, posY + j);
            }
        }
        return counter;
    }

    public boolean nextGeneration() {
        int currentState;
        int aliveNeighbours;
        int[][] nextBoard = new int[boardLength][boardHeight];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardLength; j++) {
                currentState = isAlive(j, boardHeight - 1 - i);
                aliveNeighbours = countOfAliveNeighbors(j, boardHeight - 1 - i);
                if (currentState == 0 && aliveNeighbours == 3) {
                    setAliveTempBoard(j, boardHeight - 1 - i, nextBoard);
                    nextBoard[j][boardHeight - 1 - i] = 1;
                    continue;
                }
                if (currentState == 1 && (aliveNeighbours < 2 || aliveNeighbours > 3))
                    setDeadTempBoard(j, boardHeight - 1 - i, nextBoard);
                else if (currentState == 1)
                    setAliveTempBoard(j, boardHeight - 1 - i, nextBoard);
            }
        }
        if (isGameOver(nextBoard)) {
            System.out.println("Game over!");
            board = nextBoard;
            return false;
        }
        board = nextBoard;
        return true;
    }

    private boolean isGameOver(int[][] nextBoard) {
        if (ArrayUtils.isEmpty(nextBoard))
            return true;

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[j][i] != nextBoard[j][i])
                    return false;
            }
        }
        return true;
    }


    public void printTheBoard() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[j][boardHeight - 1 - i] == 1) System.out.print("* ");
                else System.out.print(board[j][boardHeight - 1 - i] + " ");
            }
            System.out.println();
        }
    }
}
