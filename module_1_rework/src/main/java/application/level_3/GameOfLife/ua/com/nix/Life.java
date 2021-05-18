package application.level_3.GameOfLife.ua.com.nix;

import application.level_3.GameOfLife.ua.com.nix.game.Board;

public class Life {
    public final int CELLS = 60;
    public static final int TIME_DELAY = 400;

    public Life() {

    }

    public Life(int cells) {
        Life life = new Life();
        Board board = new Board(cells, cells);
        Board nextBoard = new Board(cells, cells);
        life.initializeBoard(board);
        for (int i = 0; i < 130; i++) {
            life.displayBoard(board);
            life.slow();
            life.calculateNextGeneration(board, nextBoard);
            life.transferNextToCurrent(board, nextBoard);
        }
    }

    public void initializeBoard(Board board) {
        for (int row = 0; row < CELLS; row++) {
            for (int col = 0; col < CELLS; col++) {
                int randomValue = (int) (Math.random() * 3);
                if (randomValue == 0) {
                    board.set(row, col, 1);
                }
            }
        }

    }

    public void displayBoard(Board board) {
        for (int row = 0; row < CELLS; row++) {
            for (int col = 0; col < CELLS; col++) {
                if (board.get(row, col) == 0) {
                    System.out.print(".");
                } else if (board.get(row, col) == 1) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public void calculateNextGeneration(Board currBoard, Board nextBoard) {
        for (int row = 0; row < CELLS; row++) {
            for (int col = 0; col < CELLS; col++) {
                int neighbourCount = this.countNeighbours(row, col, currBoard);
                if (currBoard.get(row, col) == 1 && neighbourCount < 2) {
                    nextBoard.set(row, col, 0);
                } else if (currBoard.get(row, col) == 1 && neighbourCount < 4) {
                    nextBoard.set(row, col, 1);
                } else if (currBoard.get(row, col) == 1 && neighbourCount > 3) {
                    nextBoard.set(row, col, 0);
                } else if (currBoard.get(row, col) == 0 && neighbourCount == 3) {
                    nextBoard.set(row, col, 1);
                } else {
                    nextBoard.set(row, col, 0);
                }
            }
        }

    }

    public int countNeighbours(int row, int col, Board board) {
        int count = 0;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < 50 && c >= col && c < 50 && (r != row || c != col) && board.get(r, c) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public void transferNextToCurrent(Board board, Board nextBoard) {
        for (int row = 0; row < CELLS; row++) {
            for (int col = 0; col < CELLS; col++) {
                board.set(row, col, nextBoard.get(row, col));
            }
        }

    }

    public void slow() {
        try {
            Thread.sleep(TIME_DELAY);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}

