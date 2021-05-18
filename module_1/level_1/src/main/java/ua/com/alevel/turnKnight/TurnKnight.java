package ua.com.alevel.turnKnight;

public class TurnKnight {
    private static final int BOARD_SIZE = 8;
    private static final String SYMBOL = " K";
    private int thisX;
    private int thisY;

    public boolean place(int X, int Y) {
        if (goodCoord(X, Y)) {
            thisX = X;
            thisY = Y;
            return true;
        } else {
            return false;
        }
    }

    public boolean move(int X, int Y) {
        if (goodCoord(X, Y)) {
            if (checkMove(X, Y)) {
                thisX = X;
                thisY = Y;
                return true;
            }
        }
        return false;
    }

    private boolean checkMove(int X, int Y) {
        final int dX = Math.abs(thisX - X);
        final int dY = Math.abs(thisY - Y);

        return ((dX == 1 && dY == 2) || dX == 2 && dY == 1);
    }

    private boolean goodCoord(int X, int Y) {
        return X >= 0 && X < BOARD_SIZE && Y >= 0 && Y < BOARD_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        {
            int i = BOARD_SIZE - 1;
            while (i >= 0) {
                sb.append(i + 1).append(" ");
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (thisX == j && thisY == i) {
                        sb.append(SYMBOL).append(" ");
                    } else {
                        sb.append(" * ");
                    }
                }
                sb.append('\n');
                i--;
            }
        }
        sb.append("   ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append((char) ('A' + i)).append("  ");
        }
        return sb.toString();
    }
}
