package ua.practice.unit3.pieces;

public class King extends Piece {

    public King(COLOUR colour) {
        this.colour = colour;
    }

    public King() {

    }

    @Override
    public boolean move(int currentY, int currentX, int toY, int toX) {
        return (Math.abs(toY - currentY) == 1) && (Math.abs(toX - currentX) == 1);
    }

    @Override
    public String toString() {
        return colour.name().substring(0, 1) + "ki";
    }
}
