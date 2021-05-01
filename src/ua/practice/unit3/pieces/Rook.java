package ua.practice.unit3.pieces;

public class Rook extends Piece {

    public Rook(COLOUR colour) {
        this.colour = colour;
    }

    public Rook() {

    }

    @Override
    public boolean move(int currentY, int currentX, int toY, int toX) {

        return ((currentY == toY && Math.abs(currentX - toX) >= 0) || (currentX == toX && Math.abs(currentY - toY) >= 0));
    }

    @Override
    public String toString() {
        return colour.name().substring(0, 1) + "r";
    }
}
