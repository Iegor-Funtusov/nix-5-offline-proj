package pieces;

public abstract class ChessPiece {
    private COLOR color;

    public ChessPiece(COLOR color){
        this.color = color;
    }

    public abstract boolean checkMove(int currentX, int currentY, int futureX, int futureY, ChessPiece[][] board);

    public COLOR getColor() {
        return color;
    }

    public enum COLOR {
        BLACK, WHITE
    }
}
