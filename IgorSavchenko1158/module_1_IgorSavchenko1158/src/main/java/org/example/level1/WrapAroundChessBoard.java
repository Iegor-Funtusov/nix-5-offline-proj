package org.example.level1;

public class WrapAroundChessBoard {
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

    public boolean moveFigure(int X, int Y) { //TODO dodo
        int deltaX = Math.abs(currentX - X);
        int deltaY = Math.abs(currentY - Y);
        if((deltaX == 2 && deltaY == 1) ||
                (deltaX == 1 && deltaY == 2)) {
//            currentX = wrap(X);
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
}
