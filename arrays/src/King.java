public class King extends ChessPiece {
    @Override
    public boolean canMove(Coordinates to) {
        return Math.abs(to.x - this.position.x) <= 1 && Math.abs(to.y - this.position.y) <= 1;
    }
}
