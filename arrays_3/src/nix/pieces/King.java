package nix.pieces;

import nix.Piece;
import nix.PieceCoordinate;

public class King extends Piece {
    @Override
    public boolean isCanMove(PieceCoordinate moveTo) {
        if (Math.abs(moveTo.x - this.pieceCoordinate.x) <= 1 && Math.abs(moveTo.y - this.pieceCoordinate.y) <= 1) {
            return true;
        }
        return false;
    }
}
