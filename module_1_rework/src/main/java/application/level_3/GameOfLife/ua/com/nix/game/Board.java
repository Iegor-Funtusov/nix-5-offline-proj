package application.level_3.GameOfLife.ua.com.nix.game;

public class Board {
    int[][] boardArray;

    public Board(int rows, int cols) {
        this.boardArray = new int[rows][cols];
    }

    public int get(int row, int col) {
        return this.boardArray[row][col];
    }

    public void set(int row, int col, int value) {
        this.boardArray[row][col] = value;
    }

    public int getRows() {
        return this.boardArray.length;
    }

    public int getCols() {
        return this.boardArray[0].length;
    }

    public String toString() {
        String result = "";

        for(int row = 0; row < this.getRows(); ++row) {
            for(int col = 0; col < this.getCols(); ++col) {
                result = result + String.valueOf(this.boardArray[row][col]);
            }

            result = result + "\n";
        }

        return result;
    }
}

