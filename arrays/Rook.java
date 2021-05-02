

public class Rook extends Coordinates{
    @Override
    public boolean PossibilityOfMove(int destX, int destY){
        return getX() == destX || getY() == destY;
    }
}
