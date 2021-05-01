package pieces;

public class Pawn extends ChessPiece {
    public Pawn(COLOR color) {
        super(color);
    }


    @Override
    public boolean isLegalMove(int currentX, int currentY, int destX, int destY) {
        if (currentX != destX) {
            return false;
        }
        if ((getColor().equals(COLOR.BLACK) && destY >= currentY) ||
                (getColor().equals(COLOR.WHITE) && destY <= currentY)) {
            return false;
        }
        return Math.abs(destY - currentY) == 1;
    }
}
