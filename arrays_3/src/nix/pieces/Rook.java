package nix.pieces;

import nix.Piece;
import nix.PieceCoordinate;

public class Rook extends Piece {
    @Override
    public boolean isCanMove(PieceCoordinate moveTo) {
        if (moveTo.x == this.pieceCoordinate.x || moveTo.y == this.pieceCoordinate.y) {
            return true;
        }
        return false;
    }
}
