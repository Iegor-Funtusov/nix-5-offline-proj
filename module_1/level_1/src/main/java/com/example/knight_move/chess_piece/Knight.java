package com.example.knight_move.chess_piece;

public class Knight extends ChessPiece{

    @Override
    public boolean isPossibleMove(int destPosX, int destPosY) {
        int dX = Math.abs(getPosX() - destPosX);
        int dY = Math.abs(getPosY() - destPosY);
        return (dX == 1 && dY == 2) || (dX == 2 && dY == 1);
    }
}
