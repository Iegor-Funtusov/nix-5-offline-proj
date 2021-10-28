import pieces.ChessPiece;

public class ChessBoard {

    public static final int BOARD_SIZE = 8;
    private ChessPiece currentPiece;
    private int currentX;
    private int currentY;

    public boolean placePiece(ChessPiece piece, int X, int Y) {
        if (fitsBoard(X, Y) && piece != null) {
            currentPiece = piece;
            currentX = X;
            currentY = Y;
            return true;
        }
        return false;
    }

    public boolean movePiece(int X, int Y) {
        if (!fitsBoard(X, Y) || currentPiece == null) {
            return false;
        }
        if (currentPiece.isLegalMove(currentX, currentY, X, Y)) {
            currentX = X;
            currentY = Y;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return currentPiece.toString() + " at " + humanize(currentX, currentY);
    }

    private String humanize(int currentX, int currentY) {
        return String.valueOf((char) ('A' + currentX)) + (currentY + 1);
    }

    private boolean fitsBoard(int X, int Y) {
        return (X >= 0 && X < BOARD_SIZE && Y >= 0 && Y < BOARD_SIZE);
    }
}
