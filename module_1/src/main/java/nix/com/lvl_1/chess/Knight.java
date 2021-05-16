package nix.com.lvl_1.chess;

public class Knight extends Piece {

    @Override
    public boolean isCanMove(PieceCoordinate moveTo) {
        if (((Math.abs(moveTo.x - this.pieceCoordinate.x) == 1) &&
                (Math.abs(moveTo.y - this.pieceCoordinate.y) == 2)) ||
                (Math.abs(moveTo.x - this.pieceCoordinate.x) == 2) &&
                (Math.abs(moveTo.y - this.pieceCoordinate.y) == 1)) {
            return true;
        }
        return false;
    }
}
