package nix.pieces;

import nix.Piece;
import nix.PieceCoordinate;

public class Queen extends Piece {

    @Override
    public boolean isCanMove(PieceCoordinate moveTo) {
        if ((Math.abs(moveTo.x - this.pieceCoordinate.x) == Math.abs(moveTo.y - this.pieceCoordinate.y))
                || moveTo.x == this.pieceCoordinate.x || moveTo.y == this.pieceCoordinate.y) {
            return true;
        }
        return false;
    }
}
