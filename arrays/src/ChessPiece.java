public abstract class ChessPiece {

    public Color color;
    public Coordinates position;

    public abstract boolean canMove(Coordinates to);

    public enum Color{
        WHITE,
        BLACK
    }
}

