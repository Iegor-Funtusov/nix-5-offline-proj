package com.example.chess.chesspiece;

public class Queen extends ChessPiece{
    @Override
    public boolean isPossibleMove(int destPosX, int destPosY) {
        return Math.abs(getPosX() - destPosX) == Math.abs(getPosY()-destPosY) ||
                getPosX() == destPosX || getPosY() == destPosY;
    }
}
