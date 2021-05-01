package pieces;

public class King extends ChessPiece{

    public King(COLOR color) {
        super(color);
    }

    @Override
    public boolean isLegalMove(int currentX, int currentY, int destX, int destY) {
        int deltaX = Math.abs(currentX - destX);
        int deltaY = Math.abs(currentY - destY);
        System.out.println("deltaX = " + deltaX);
        System.out.println("deltaY = " + deltaY);
        return (
                deltaX <= 1 && deltaY <= 1
                );
    }
}
