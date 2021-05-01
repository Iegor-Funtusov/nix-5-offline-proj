package nix.pieces;

import nix.Piece;
import nix.PieceCoordinate;

public class Pawn extends Piece {

    @Override
    public boolean isCanMove(PieceCoordinate moveTo) {
        if (this.pieceColor == PieceColor.BLACK) {
            if (moveTo.y != pieceCoordinate.y - 1) {
                return false;
            }
        }

        if (this.pieceColor == PieceColor.WHITE) {
            if (moveTo.y != pieceCoordinate.y + 1) {
                return false;
            }
        }

        if (moveTo.x != this.pieceCoordinate.x){
            return false;
        }
        return true;
    }
}
