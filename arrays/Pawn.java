
public class Pawn extends Coordinates{
    @Override
    public boolean PossibilityOfMove(int destX, int destY){
        return destY - getY() == 1 && getX() == destX;
    }
}
