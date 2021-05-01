package ua.practice.unit3.pieces;

public class Bishop extends Piece {

    public Bishop(COLOUR colour) {
        this.colour = colour;
    }

    public Bishop() {

    }

    @Override
    public boolean move(int currentY, int currentX, int toY, int toX) {

        return (Math.abs(toY - currentY) == Math.abs(toX - currentX));
    }

    @Override
    public String toString() {
        return colour.name().substring(0, 1) + "b";
    }
}
