package example;

public class Peshka extends ChessFigure {

    public Peshka() {
    }

    public Peshka(String color, int x, int y) {
        super(color, x, y);
    }


    //Peshka moves one step vertycally up
    @Override
    protected boolean canBeMovedTo(int x, int y) {
        int currentX = getX();
        int currentY = getY();
        if (x == currentX && (y == currentY + 1)) {
           return true;
        }
        return false;
    }
}
