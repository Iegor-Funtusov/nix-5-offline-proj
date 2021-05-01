package ua.practice.unit3.pieces;

public abstract class Piece {
    COLOUR colour = COLOUR.WHITE;
    public abstract boolean move(int currentY, int currentX, int toY, int toX);

    public void setColour(COLOUR colour) {
        this.colour = colour;
    }
}
