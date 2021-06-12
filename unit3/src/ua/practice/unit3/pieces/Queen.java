package ua.practice.unit3.pieces;

public class Queen extends Piece {

    public Queen(COLOUR colour) {
        this.colour = colour;
    }

    public Queen() {

    }

    @Override
    public boolean move(int currentY, int currentX, int toY, int toX) {
        return (Math.abs(toY - currentY) == Math.abs(toX - currentX)) || ((currentY == toY && Math.abs(currentX - toY) <= 7) || (currentX == toX && Math.abs(currentX - toY) <= 7));
    }

    @Override
    public String toString() {
        return colour.name().substring(0, 1) + "q";
    }
}
