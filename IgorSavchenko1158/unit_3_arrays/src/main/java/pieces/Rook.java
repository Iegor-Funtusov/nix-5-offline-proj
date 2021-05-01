package pieces;

public class Rook extends ChessPiece {
    public Rook(COLOR color) {
        super(color);
    }

    @Override
    public boolean isLegalMove(int currentX, int currentY, int destX, int destY) {
        return (
                (currentX != destX && currentY == destY) ||
                        (currentY != destY && currentX == destX)
        );
    }
}
