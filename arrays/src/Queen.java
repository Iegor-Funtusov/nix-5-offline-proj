public class Queen extends ChessPiece {
    @Override
    public boolean canMove(Coordinates to) {
        if ((to.x != this.position.x && ((to.x != this.position.x + 1 && to.x != this.position.x + 2 && to.x != this.position.x + 3 && to.x != this.position.x + 4 &&
                to.x != this.position.x + 5 && to.x != this.position.x + 6 && to.x != this.position.x + 7 && to.x != this.position.x + 8)) &&
                (to.x != this.position.x - 1 && to.x != this.position.x - 2 && to.x != this.position.x - 3 && to.x != this.position.x - 4 &&
                        to.x != this.position.x - 5 && to.x != this.position.x - 6 && to.x != this.position.x - 7 && to.x != this.position.x - 8))) {

            if ((to.y != this.position.y + 1 && to.y != this.position.y + 2 && to.y != this.position.y + 3 && to.y != this.position.y + 4 &&
                    to.y != this.position.y + 5 && to.y != this.position.y + 6 && to.y != this.position.y + 7 && to.y != this.position.y + 8) &&
                    (to.y != this.position.y - 1 && to.x != this.position.y - 2 && to.y != this.position.y - 3 && to.y != this.position.y - 4 &&
                            to.y != this.position.y - 5 && to.y != this.position.y - 6 && to.y != this.position.y - 7 && to.y != this.position.y - 8)) {
                return false;
            }
        }
        return true;
    }
}

