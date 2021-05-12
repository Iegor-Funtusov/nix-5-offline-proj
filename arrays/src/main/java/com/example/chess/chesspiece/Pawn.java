package com.example.chess.chesspiece;

public class Pawn extends ChessPiece{

    @Override
    public boolean isPossibleMove(int destPosX, int destPosY) {
        return destPosY - getPosY() == 1 && getPosX() == destPosX;
    }
}
