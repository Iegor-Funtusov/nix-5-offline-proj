public class King extends ChessPiece {
    @Override
    public boolean canMove(Coordinates to) {
        if (to.x != this.position.x &&
                (to.x != this.position.x + 1 &&
                        to.x != this.position.x - 1)) {
            return false;
        }
        if (this.color == Color.WHITE) {
            if (to.y != position.y + 1 &&
                    to.y != position.y - 1) {
                return false;
            }
        } else {
            if (to.y != position.y - 1 &&
                    to.y != position.y + 1) {
                return false;
            }
        }
        return true;
    }
}
