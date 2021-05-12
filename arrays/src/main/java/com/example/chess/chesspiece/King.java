package com.example.chess.chesspiece;

public class King extends ChessPiece{
    @Override
    public boolean isPossibleMove(int destPosX, int destPosY) {
        return Math.abs(getPosX() - destPosX) <= 1 &&
                Math.abs(getPosY()-destPosY) <= 1;
    }
}
