

public class Queen extends Coordinates{
    @Override
    public boolean PossibilityOfMove(int destX, int destY){
        return Math.abs(getX() - destX) == Math.abs(getY() - destY) || getX() == destX ||
                getY() == destY;
    }
}
