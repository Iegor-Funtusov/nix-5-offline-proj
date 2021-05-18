package ua.com.alevel.controlpanel;

import ua.com.alevel.GameOfLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThirdLevel {

    static int[][] board;
    static int x;
    static int y;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int aliveNeighbors(int x, int y) {
        int count = 0;
        if (y < ThirdLevel.y - 1 && board[x][y + 1] == 1) count++;
        if (y > 0 && board[x][y - 1] == 1) count++;
        if (x < ThirdLevel.x - 1 && board[x + 1][y] == 1) count++;
        if (x > 0 && board[x - 1][y] == 1) count++;
        if (x < ThirdLevel.x - 1 && y < ThirdLevel.y - 1 && board[x + 1][y + 1] == 1) count++;
        if (x > 0 && y > 0 && board[x - 1][y - 1] == 1) count++;
        return count;
    }

    public static void nextStage() {
        int alive;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                alive = aliveNeighbors(i, j);
                if (board[i][j] == 1) {
                    if (alive < 2 || alive > 3) {
                        board[i][j] = 0;
                    }
                } else if (alive == 3) {
                    board[i][j] = 1;
                }
            }
        }
        System.out.println("Next stage");
        printBoard();
    }

    public static void printBoard() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public static void run() throws IOException {
        System.out.println("Game of life started\n" +
                "Input cord of board");
        System.out.println("Input x cord:");
        x = Integer.parseInt(reader.readLine());
        System.out.println("Input y cord:");
        y = Integer.parseInt(reader.readLine());
        board = GameOfLife.createCells(reader, x, y);
        printBoard();
        do {
            nextStage();
            System.out.println("Next stage?\n" +
                    "1 - yes\n" +
                    "2 - no");
        } while (!reader.readLine().equals("2"));
    }

}
