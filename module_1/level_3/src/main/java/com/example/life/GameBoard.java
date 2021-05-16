package com.example.life;

public class GameBoard {
    private final int sizeM;
    private final int sizeN;
    private Cell[][] cells;

    public GameBoard(int sizeM, int sizeN) {
        this.sizeM = sizeM;
        this.sizeN = sizeN;
        initCells();
    }

    private void initCells(){
        cells = new Cell[sizeM][sizeN];
        for (int i = 0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void nextStateOfGameBoard(){
        countNeighborsOfEachCell();
        updateStateOfCell();
    }

    private void updateStateOfCell(){
        for (int i = 0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                cells[i][j].nextState();
            }
        }
    }

    private void countNeighborsOfEachCell(){
        for (int i = 0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                cells[i][j].setCountNeighbors(countLiveNeighbors(i,j));
            }
        }
    }

    private int countLiveNeighbors(int i, int j) {
        int counts = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, sizeM - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, sizeN - 1); y++) {
                counts += cells[x][y].getCurrentState();
            }
        }
        counts -= cells[i][j].getCurrentState();
        return counts;
    }

    public void printGameBoard(){
        for (int i = 0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                System.out.print(cells[i][j]+" ");
            }
            System.out.println();
        }
    }

}
