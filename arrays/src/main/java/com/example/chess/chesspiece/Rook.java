package com.example.chess.chesspiece;

public class Rook extends ChessPiece{
    @Override
    public boolean isPossibleMove(int destPosX, int destPosY) {
        return getPosX() == destPosX || getPosY() == destPosY;
    }
}
