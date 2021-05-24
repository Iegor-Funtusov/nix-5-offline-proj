package application.level_1.KnightMove.ua.com.nix.knight;

public class Knight {

    public Coordinates position;

    public boolean canMove(Coordinates to) {
        return ((Math.abs(to.x - this.position.x) == 1) && (Math.abs(to.y - this.position.y) == 2)) ||
                (Math.abs(to.x - this.position.x) == 2) && (Math.abs(to.y - this.position.y) == 1);
    }
}
