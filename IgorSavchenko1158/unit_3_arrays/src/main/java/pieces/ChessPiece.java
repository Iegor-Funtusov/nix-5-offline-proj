package pieces;

public abstract class ChessPiece {
    private final COLOR color;

    protected ChessPiece(COLOR color) {
        this.color = color;
    }

    public abstract boolean isLegalMove(int currentX, int currentY, int destX, int destY);

    public COLOR getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getColor().toString().charAt(0) + getColor().toString().substring(1).toLowerCase() + " " +
                this.getClass().getSimpleName();
    }

    public enum COLOR {
        BLACK, WHITE
    }
}
