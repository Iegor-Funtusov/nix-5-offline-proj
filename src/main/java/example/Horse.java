package example;

public class Horse extends ChessFigure {

    public Horse(String color, int x, int y) {
        super(color, x, y);
    }

    //Horse moves as letter 'Г'
    @Override
    protected boolean canBeMovedTo(int x, int y) {
        int currentX = getX();
        int currentY = getY();

        if(((Math.abs(currentX - x) == 2 && Math.abs(currentY - y) == 1)
                || (Math.abs(currentX - x) == 1 && Math.abs(currentY - y) == 2))){
            return true;
        }
        return false;
    }
        }


