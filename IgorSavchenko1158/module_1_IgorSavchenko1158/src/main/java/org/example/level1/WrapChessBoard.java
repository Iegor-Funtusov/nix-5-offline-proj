package org.example.level1;

public class WrapChessBoard {
    private static final int BOARD_SIZE = 8;
    private static final String SYMBOL = "K";
    private int currentX;
    private int currentY;

    public boolean placeFigure(int X, int Y) {
        if (!fitsBoard(X, Y)) {
            return false;
        }

        currentX = X;
        currentY = Y;
        return true;
    }

    public boolean moveFigure(int X, int Y) {
        if (!fitsBoard(X, Y)) {
            return false;
        }
        if (checkMove(X, Y)) {
            currentX = X;
            currentY = Y;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = BOARD_SIZE - 1; i >= 0; i--) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (currentX == j && currentY == i) {
                    sb.append(SYMBOL).append(" ");
                } else {
                    sb.append("_ ");
                }
            }
            sb.append('\n');
        }
        sb.append("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append((char) ('A' + i)).append(" ");
        }
        return sb.toString();
    }

    private boolean fitsBoard(int X, int Y) {
        return X >= 0 && X < BOARD_SIZE && Y >= 0 && Y < BOARD_SIZE;
    }

    private boolean checkMove(int X, int Y) {
        final int dX = Math.abs(currentX - X);
        final int dY = Math.abs(currentY - Y);
        final int wrapX = Math.abs(dX - BOARD_SIZE);
        final int wrapY = Math.abs(dY - BOARD_SIZE);

        return dX == 2 && dY == 1 ||
                dX == 1 && dY == 2 ||
                dX == 2 && wrapY == 1 ||
                dX == 1 && wrapY == 2 ||
                wrapX == 2 && dY == 1 ||
                wrapX == 1 && dY == 2 ||
                wrapX == 2 && wrapY == 1 ||
                wrapX == 1 && wrapY == 2;
    }
}
