package ua.practice.unit3.pieces;

public class Knight extends Piece {

    public Knight(COLOUR colour) {
        this.colour = colour;
    }

    public Knight() {

    }

    @Override
    public boolean move(int currentY, int currentX, int toY, int toX) {
        int resX = toY - currentY;
        int resY = toX - currentX;
        return Math.abs(resX) == 2 && Math.abs(resY) == 1
                || Math.abs(resY) == 2 && Math.abs(resX) == 1;
    }


    @Override
    public String toString() {
        return colour.name().substring(0, 1) + "k";
    }
}
