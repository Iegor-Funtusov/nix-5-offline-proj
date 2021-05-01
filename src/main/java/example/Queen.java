package example;

public class Queen extends ChessFigure {

    public Queen() {}

    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

//Queen moves as Tura and Elephant
    @Override
    protected boolean canBeMovedTo(int x, int y) {
        int currentX = getX();
        int currentY = getY();
        if ((((Math.abs(currentX - x) <= 7) && (currentY == y)
                || (currentX == x) && (Math.abs(currentY - y) <= 7)))
                || ((Math.abs(currentY - y) <= 7) && Math.abs((currentY - y)) == Math.abs(currentX - x))) {
            return true;
        }
        return false;
    }
}
