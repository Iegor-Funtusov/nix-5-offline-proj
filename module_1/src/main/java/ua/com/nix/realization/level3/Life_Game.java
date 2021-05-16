package ua.com.nix.realization.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Life_Game {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int countSurrounding(int[][] board, int a, int b) {
        int count = 0;
        int[][] surrounding = {
                {a - 1, b - 1},
                {a - 1, b    },
                {a - 1, b + 1},
                {a    , b - 1},
                {a    , b + 1},
                {a + 1, b - 1},
                {a + 1, b    },
                {a + 1, b + 1}};
        for (int i[]: surrounding) {
            try {
                if (board[i[0]][i[1]] == 1) {
                    count++;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return count;
    }

    void printBoard(int[][] board) {
        for (int[] i: board) {
            for (int j: i) {
                if (j == 1) {
                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
     void enteringLive(int [][] board) throws IOException {
        int k,l;

        while (true){
            System.out.println("Bring cells to life (y/n)(Y/N)");
            String s = reader.readLine();
            if(s.equals("y")||s.equals("Y")) {
                System.out.println("Enter cell indices to alive:  ");
                System.out.println("Enter row's index: ");

                while (true) {
                    k = Integer.parseInt(reader.readLine());
                    if (k < 0 || k > board.length) {
                        System.out.println("Incorrect row's index,try again: ");
                    }
                    else {
                        break;
                    }
                }
                System.out.println("Enter column's index: ");

                while (true) {
                    l = Integer.parseInt(reader.readLine());
                    if (l < 0 || l > board.length) {
                        System.out.println("Incorrect column's index,try again: ");
                    }
                    else {
                        break;
                    }
                }
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if (i == k && j == l) {
                            board[i][j] = 1;
                        }
                    }
                }
            }
            if(s.equals("n")||s.equals("N")){
                break;
            }
        }
    }
    public  int [][] creatingDesk() throws IOException {
        System.out.println("Input size of your desk: [m][n]");
        System.out.println("Enter m: ");
        int m = Integer.parseInt(reader.readLine());
        System.out.println("Enter n: ");
        int n = Integer.parseInt(reader.readLine());

        int[][] nextBoard = new int[m][n];
        for (int i = 0; i < nextBoard.length; i++) {
            for (int j = 0; j < nextBoard.length; j++) {
                nextBoard[i][j]=0;
            }
        }
        return nextBoard;
    }
    public void processing() throws IOException {
        int counter = 1;
        int [][]nextBoard = creatingDesk();
        enteringLive(nextBoard);
        int[][] board = new int[nextBoard.length][nextBoard[0].length];
        while (counter>0){
            for (int i = 0; i < nextBoard.length; i++) {
                System.arraycopy(nextBoard[i], 0, board[i], 0, nextBoard[i].length);
            }
            printBoard(board);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1 && !(countSurrounding(board, i, j) == 2 || countSurrounding(board, i, j) == 3)) {
                        nextBoard[i][j] = 0;
                    }
                    else if (board[i][j] == 0 && countSurrounding(board, i, j) == 3) {
                        nextBoard[i][j] = 1;
                    }
                }
            }
            System.out.println("For next step press Enter,For exit any characters");
            String s = reader.readLine();
            if("".equals(s))
            {
                counter++;
            }
            else counter=0;
        }
    }
}