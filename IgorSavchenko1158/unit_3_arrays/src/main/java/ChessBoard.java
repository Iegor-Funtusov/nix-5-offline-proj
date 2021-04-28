import pieces.ChessPiece;

public class ChessBoard {
    private final ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    public boolean placePiece(ChessPiece piece, int X, int Y) {
        if (fitsBoard(X, Y) && board[X][Y] == null) {
            board[X][Y] = piece;
            return true;
        }
        return false;
    }

    public boolean movePiece(int X, int Y, int futureX, int futureY) {
        if (!fitsBoard(X, Y) || !fitsBoard(futureX, futureY) || board[X][Y] == null) {
            return false;
        }

        if (board[X][Y].checkMove(X, Y, futureX, futureY, getBoard())) {
            board[futureX][futureY] = board[X][Y];
            board[X][Y] = null;
            return true;
        }
        return false;
    }

    /**
     * Returns a copy of current board to ensure encapsulation(I think)
     */
    public ChessPiece[][] getBoard() {
        ChessPiece[][] copy = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int j = 7; j >= 0; j--) {
            sb.append(j + 1).append(' ');
            for (int i = 0; i < 8; i++) {
                sb.append(board[i][j] == null ? "_" : board[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        sb.append("  ");
        for (int i = 65; i < 73; i++) {
            sb.append((char) i).append(' ');
        }

        return sb.toString();
    }

    private boolean fitsBoard(int X, int Y) {
        return (X >= 0 && X < 8 && Y >= 0 && Y < 8);
    }
}
