package pieces;

public class Bishop extends ChessPiece {
    public Bishop(COLOR color) {
        super(color);
    }

    @Override
    public boolean isLegalMove(int currentX, int currentY, int destX, int destY) {
        int deltaX = Math.abs(currentX - destX);
        int deltaY = Math.abs(currentY - destY);

        return deltaX == deltaY;
    }
}
