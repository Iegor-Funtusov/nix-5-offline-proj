package ua.practice.unit3;

import ua.practice.unit3.pieces.Piece;

import java.util.Objects;

public class Position {
    private final int positionX;
    private final int positionY;
    private Piece piece;

    public Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "" + (positionX + 1) + (char) (positionY + 65) + Objects.requireNonNullElse(piece, "  ");
    }
}
