package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class GameOfLife {

    public static int[][] createCells(BufferedReader reader, int n, int m) throws IOException {
        System.out.println("Pick generation sells\n" +
                "1 -> Random generation\n" +
                "2 -> User generation\n");
        int[][] board = new int[n][m];
        switch (reader.readLine()) {
            case "1":
                board = generateCells(n, m);
                break;
            case "2":
                System.out.println("Enter number of alive cells:");
                int alive = Integer.parseInt(reader.readLine());
                int i, j;
                while (alive != 0) {
                    System.out.println("Enter x(start at 0) :");
                    i = Integer.parseInt(reader.readLine());
                    System.out.println("Enter y(start at 0) :");
                    j = Integer.parseInt(reader.readLine());
                    System.out.println("Next cell");
                    board[i][j] = 1;
                    alive--;
                }
                break;
            default: {
                System.out.println("Wrong input. Pick 1 or 2");
            }
        }
        return board;
    }

    public static int[][] generateCells(int n, int m) {
        Random random = new Random();
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = random.nextInt(2);
            }
        }
        return result;
    }

}