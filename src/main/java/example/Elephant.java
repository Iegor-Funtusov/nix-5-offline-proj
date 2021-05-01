package example;

public class Elephant extends ChessFigure {

    public Elephant(String color, int x, int y) {
        super(color, x, y);
    }

    //Elephant moves diagonally on all the board
    @Override
    protected boolean canBeMovedTo(int x, int y) {
        int currentX = getX();
        int currentY = getY();
        if ((Math.abs(currentY - y) <= 7) && Math.abs((currentY - y)) == Math.abs(currentX - x)) {
            return true;
        }
        return false;
    }
}
