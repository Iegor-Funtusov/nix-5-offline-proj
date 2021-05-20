package pieces;

public class Queen extends ChessPiece {

    public Queen(COLOR color) {
        super(color);
    }

    @Override
    public boolean isLegalMove(int currentX, int currentY, int destX, int destY) {
        return (new Bishop(COLOR.BLACK).isLegalMove(currentX, currentY, destX, destY)) ||
                (new Rook(COLOR.BLACK).isLegalMove(currentX, currentY, destX, destY));
    }
}
