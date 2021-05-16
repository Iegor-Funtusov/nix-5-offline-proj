package nix.com.lvl_1.chess;

public abstract class Piece {
    public PieceCoordinate pieceCoordinate;

    public abstract boolean isCanMove(PieceCoordinate moveTo);
}
