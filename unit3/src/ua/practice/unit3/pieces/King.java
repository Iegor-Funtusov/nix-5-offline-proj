package ua.practice.unit3.pieces;

public class King extends Piece {

    public King(COLOUR colour) {
        this.colour = colour;
    }

    public King() {

    }

    @Override
    public boolean move(int currentY, int currentX, int toY, int toX) {
        int resY = Math.abs(toY - currentY);
        int resX = Math.abs(toX - currentX);
        return (resY <= 1) && (resY>=0) && (resX <= 1) && (resX>=0) ;
    }

    @Override
    public String toString() {
        return colour.name().substring(0, 1) + "ki";
    }
}
