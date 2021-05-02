

public class King extends Coordinates{
    @Override
    public boolean PossibilityOfMove(int destX, int destY){
        return Math.abs(getX() - destX) <= 1 && Math.abs(getY() - destY) <= 1;
    }
}
