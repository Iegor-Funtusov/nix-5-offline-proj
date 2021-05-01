public class Rook extends ChessPiece {
    @Override
    public boolean canMove(Coordinates to) {
        return to.x == this.position.x || to.y == this.position.y;
    }
}
