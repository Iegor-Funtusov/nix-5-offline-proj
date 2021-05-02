
public class Horse extends Coordinates {
    @Override
    public boolean PossibilityOfMove(int destX, int destY){
        int dX = Math.abs(getX() - destX);
        int dY = Math.abs(getY() - destY);
        return (dX == 1 && dY == 2) || (dX == 2 && dY == 1);
    }
}
