package example;

public class Tura extends ChessFigure {

    public Tura() {}

    public Tura(String color, int x, int y) {
        super(color, x, y);
    }
// Tura moves horizontally and vertically on all  board
    @Override
    protected boolean canBeMovedTo(int x, int y) {
        int currentX = getX();
        int currentY = getY();
        if ((Math.abs(currentX - x) <= 7) && (currentY == y)
                || (currentX == x) && (Math.abs(currentY - y) <= 7)) {
            return true;
        }
        return false;
    }
}
