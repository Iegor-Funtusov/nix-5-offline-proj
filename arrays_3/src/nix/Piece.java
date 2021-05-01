package nix;

public abstract class Piece {
    public enum PieceColor {
        WHITE, BLACK
    }

    public PieceColor pieceColor;
    public PieceCoordinate pieceCoordinate;

    public abstract boolean isCanMove(PieceCoordinate moveTo);
}
