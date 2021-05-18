package level3;

import java.util.Random;

public class GameOfLife {
    private boolean[][] matrix;

    public GameOfLife(int d) {
        this.matrix = new boolean[d][d];
    }

    public void setCellAlive(int i, int j) {
        matrix[i][j] = true;
    }

    public void setCellDead(int i, int j) {
        matrix[i][j] = false;
    }

    public void show() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((matrix[i][j] ? "*" : ".") + " ");
            }
            System.out.print("\n");
        }
        for (int i = 0; i < matrix.length; i++){
            System.out.print("==");
        }
        System.out.print("\n");
    }

    public boolean[][] copy(boolean[][] matrix){
        boolean[][] newMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j]){
                    newMatrix[i][j] = true;
                }
            }
        }
        return newMatrix;
    }

    public void execCycle() {
        boolean[][] oldMatrix = copy(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int n = countNeighbours(i, j, oldMatrix);
                if (oldMatrix[i][j]) {
                    if (n < 2){
                        setCellDead(i, j);
                    } else if (n > 3){
                        setCellDead(i, j);
                    }
                }
                else{
                    if (n == 3){
                        setCellAlive(i, j);
                    }
                }
            }
        }
    }

    public int countNeighbours(int i, int j, boolean[][] m){
        int count = 0;
        int x;
        int y;
        for (int k = i - 1; k <= i + 1; k++){
            for (int l = j - 1; l <= j + 1; l++){
                x = k;
                y = l;
                if (x == -1) {
                    x = m.length - 1;
                }
                if (y == -1) {
                    y = m.length - 1;
                }
                if (x == m.length) {
                    x = 0;
                }
                if (y == m.length) {
                    y = 0;
                }
                if ((m[x][y]) && !(x == i && y == j)) count++;
            }
        }
        return count;
    }

    public void populateRandom(int n){
        Random r = new Random();
        int alive = 0;
        while (alive < n) {
            int i = r.nextInt(matrix.length);
            int j = r.nextInt(matrix.length);
            if (!matrix[i][j]){
                setCellAlive(i, j);
                alive++;
            }
        }
    }

    public void placePentaDecathlon(){
        int middle = matrix.length / 2;
        for (int i = middle - 4; i < middle + 4; i++){
            setCellAlive(i, middle - 1);
            setCellAlive(i, middle + 1);
            setCellAlive(i, middle);
        }
        setCellDead(middle - 3, middle);
        setCellDead(middle + 2, middle);
    }

    public void placeGlider(){
        int middle = matrix.length / 2;
        for (int j = middle - 1; j <= middle + 1; j++){
            setCellAlive(middle - 1, j);
        }
        setCellAlive(middle, middle - 1);
        setCellAlive(middle + 1, middle);
    }
}