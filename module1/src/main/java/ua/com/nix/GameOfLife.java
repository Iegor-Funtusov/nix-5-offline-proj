package ua.com.nix;

public class GameOfLife {

    int m;
    int n;
    int[][] board;

    public GameOfLife(int m, int n) {
        this.m = m;
        this.n = n;
        this.board = new int[m][n];
    }

    public void printBoard() {
        System.out.println("---");
        for (int j = 0; j < n; j++) {
            String line = "|";
            for (int i = 0; i < m; i++) {
                if(this.board[i][j] == 0) {
                    line = line + ".";
                }
                else {
                    line = line + "*";
                }
            }
            line = line + "|";
            System.out.println(line);
        }
        System.out.println("----\n");
    }

    public void setDead(int i, int j){
        this.board[i][j] = 0;
    }

    public void setAlive(int i, int j){
        this.board[i][j] = 1;
    }

    public int countOfAliveNeighbours(int i, int j){
        int count = 0;

        count += getStatus(i - 1,j - 1);
        count += getStatus(i,j - 1);
        count += getStatus(i + 1, j - 1);
        count += getStatus(i - 1,j);
        count += getStatus(i + 1,j);
        count += getStatus(i - 1,j + 1);
        count += getStatus(i,j + 1);
        count += getStatus(i + 1,j + 1);

        return count;
    }

    public int getStatus(int i, int j){
        if (i < 0 || i >= m) {
            return 0;
        }

        if (j < 0 || j >= n) {
            return 0;
        }

        return this.board[i][j];
    }

    public void move() {
        int[][] newBoard = new int[m][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int counter = countOfAliveNeighbours(i, j);
                if (getStatus(i, j) == 1){
                    if (counter < 2)
                        newBoard[i][j] = 0;
                    if (counter == 2 || counter == 3)
                        newBoard[i][j] = 1;
                    if (counter > 3)
                        newBoard[i][j] = 0;
                }
                else if (this.board[i][j] == 0) {
                    if (counter == 3)
                        newBoard[i][j] = 1;
                }
            }
        }
        this.board = newBoard;
    }
}
