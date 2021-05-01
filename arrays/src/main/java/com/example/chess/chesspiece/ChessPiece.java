package com.example.chess.chesspiece;

public abstract class ChessPiece {

    private int posX;
    private int posY;
    private ChessColor color;

    public abstract boolean isPossibleMove(int destPosX, int destPosY);

    public void setPosition(int posX, int posY){
            setPosX(posX);
            setPosY(posY);
    }

    public boolean isChessboardBound(int posX, int posY){
        return posX < 9 && posX > 0 && posY < 9 && posY > 0;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        if(posX < 9 && posX > 0){
            this.posX = posX;
        }
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        if(posY < 9 && posY > 0) {
            this.posY = posY;
        }
    }

    public ChessColor getColor() {
        return color;
    }

    public void setColor(ChessColor color) {
        this.color = color;
    }
}
