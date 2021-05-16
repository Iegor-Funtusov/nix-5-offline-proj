package ua.com.nix.realization.level1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessGame {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ChessBoard chessBoard = new ChessBoard();
    String[][] cells = chessBoard.create();
    String figure = "Hrs";
    String location = null;
    String destination = null;
    int x_from = 0;
    int y_from = 0;


    public void show() {
        chessBoard.show(cells);
    }

    public void EnteringLocation() throws IOException {
        chessBoard.show(cells);
        System.out.println("Enter location's coordinates: ");

        LocatingLabel:while (true) {
            location = reader.readLine();
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    if (cells[x][y].equals(location + " ")) {
                        cells[x][y] = figure + " ";
                        x_from = x;
                        y_from = y;
                        break LocatingLabel;
                    }
                }
            }
            System.out.println("Incorrect location,try again: ");
        }
        chessBoard.show(cells);
    }

    public void EnteringDestination() throws IOException {
        System.out.println("Enter destination's coordinates");
        destination = reader.readLine();
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].equals(destination + " ")) {
                    if (cells[x_from][y_from].equals("Hrs ")) {
                        if ((Math.abs(x_from - x) == 2 && Math.abs(y_from - y) == 1) ||
                                (Math.abs(x_from - x) == 1 && Math.abs(y_from - y) == 2)) {
                            cells[x][y] = cells[x_from][y_from];
                            cells[x_from][y_from] = location + " ";
                            System.out.println("Hourse can move like that!");
                        } else {
                            System.out.println("Hourse can't move like that,try again: ");
                            return;
                        }
                    }
                }
            }
        }
        chessBoard.show(cells);
    }
    public static class ChessBoard {
        String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String [][] arr = new String[8][8];
        public String[][] create(){
            for (int i = letter.length - 1; i >= 0; i--) {
                for (int j = 0; j < letter.length; j++) {
                    arr[i][j] = (letter[j] + (i + 1) + " ");
                }
            }
            return arr;
        }
        public void show(String[][] arr)
        {
            for (int i = arr.length-1; i>=0; i--) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}

