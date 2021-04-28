package pieces;

public class Pawn extends ChessPiece {
    public Pawn(COLOR color) {
        super(color);
    }


    @Override
    public boolean checkMove(int currentX, int currentY, int futureX, int futureY, ChessPiece[][] board) {
        if (futureX != currentX) {
            return false;
        }
        if(getColor().equals(COLOR.BLACK) && futureY >= currentY) {
            return false;
        }
        if(getColor().equals(COLOR.WHITE) && futureY <= currentY) {
            return false;
        }
        if(Math.abs(futureY - currentY) != 1) {
            return false;
        }
        if(board[futureX][futureY] != null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getColor().equals(COLOR.BLACK)? "A" : "1";
    }
}
