package ua.practice.unit3.pieces;

public class Pawn extends Piece {

    public Pawn(COLOUR colour) {
        this.colour = colour;
    }

    public Pawn() {

    }

    @Override
    public boolean move(int currentY, int currentX, int toY, int toX) {
        if (colour == COLOUR.WHITE) return (toY - currentY == 1 && currentX == toX);
        else return (currentY - toY == 1 && currentX == toX);
    }


    @Override
    public String toString() {
        return colour.name().substring(0, 1) + "p";
    }
}
