package example;

public class King extends ChessFigure{

    public King(String color, int x, int y) {
        super(color, x, y);
    }

    //King moves horizontally and vertically on one step
    @Override
    protected boolean canBeMovedTo(int x, int y) {
        int currentX = getX();
        int currentY = getY();
        if(Math.abs((currentX - x )) == 1 || (Math.abs(currentY - y) == 1)){
            return true;
        }
        return false;
    }
}
