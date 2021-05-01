package pieces;

public class Knight extends ChessPiece {

    public Knight(COLOR color) {
        super(color);
    }

    @Override
    public boolean isLegalMove(int currentX, int currentY, int destX, int destY) {
        int deltaX = Math.abs(currentX - destX);
        int deltaY = Math.abs(currentY - destY);
        return (
                (deltaX == 2 && deltaY == 1) ||
                        (deltaX == 1 && deltaY == 2)
        );
    }
}
