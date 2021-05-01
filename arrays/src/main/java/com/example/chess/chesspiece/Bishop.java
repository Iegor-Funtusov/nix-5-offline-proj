package com.example.chess.chesspiece;

public class Bishop extends ChessPiece{
    @Override
    public boolean isPossibleMove(int destPosX, int destPosY) {
        return Math.abs(getPosX() - destPosX) == Math.abs(getPosY()-destPosY);
    }
}
