package com.Lachenko_Kirill.project;

import java.util.Locale;

public class ChessFigure {
    private int X;
    private int Y;
    private String color;
    private FigureName figureName;

    public ChessFigure(int x, int y, String color, int name) {
        if (x > 0 && x < 9) {
            this.X = x;
        } else throw new IllegalArgumentException("Wrong coordinate");
        if (y > 0 && y < 9) {
            this.Y = y;
        } else throw new IllegalArgumentException("Wrong coordinate");
        if (color.equalsIgnoreCase("black") || color.equalsIgnoreCase("white")) {
            this.color = color.toLowerCase(Locale.ROOT);
        } else throw new IllegalArgumentException("Wrong coordinate");
        switch (name) {
            case 1:
                figureName = FigureName.PAWN;
                break;
            case 2:
                figureName = FigureName.KNIGHT;
                break;
            case 3:
                figureName = FigureName.BISHOP;
                break;
            case 4:
                figureName = FigureName.ROOK;
                break;
            case 5:
                figureName = FigureName.QUEEN;
                break;
            case 6:
                figureName = FigureName.KING;
                break;
            default:
                throw new IllegalArgumentException("Wrong figure name");
        }
    }

    public boolean makeMove(int x, int y) {
        switch (figureName){
            case KING -> {
                return kingMove(x, y);
            }
            case QUEEN -> {
                return queenMove(x,y);
            }
            case PAWN -> {
                return pawnMove(x, y);
            }
            case ROOK -> {
                return rookMove(x, y);
            }
            case KNIGHT -> {
                return knightMove(x, y);
            }
            case BISHOP -> {
                return bishopMove(x, y);
            }
        }
        return false;
    }

    private void updateCoordinates(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    private boolean bishopMove(int x, int y){
        if(Math.abs(this.X - x ) == Math.abs(this.Y - y)) {
            updateCoordinates(x, y);
            return true;
        }
        return false;
    }

    private boolean pawnMove(int x, int y) {
        if(((this.X == x) && (this.Y == (y - 1))) && this.color.equals("white")) {
            updateCoordinates(x, y);
            return true;
        }
        if(((this.X == x) && (this.Y == (y + 1))) && this.color.equals("black")) {
            updateCoordinates(x, y);
            return true;
        }
        return false;
    }

    private boolean knightMove(int x, int y) {
        if((Math.abs(this.X - x) == 1)  && (Math.abs(this.Y - y) == 2)) {
            updateCoordinates(x, y);
            return true;
        }
        if((Math.abs(this.X - x) == 2)  && (Math.abs(this.Y - y) == 1)) {
            updateCoordinates(x, y);
            return true;
        }
        return false;
    }

    private boolean rookMove(int x, int y) {
        if (((this.X == x) && (this.Y != y)) ||
                ((this.Y == y) && (this.X != x))) {
            updateCoordinates(x, y);
            return true;
        }
        return false;
    }

    private boolean queenMove(int x, int y) {
        if(this.X == x && this.Y != y) {
            updateCoordinates(x,y);
            return true;
        }
        if(this.Y == y && this.X != x) {
            updateCoordinates(x, y);
            return true;
        }
        if(Math.abs(this.X - x ) == Math.abs(this.Y - y)) {
            updateCoordinates(x, y);
            return true;
        }
        return false;
    }

    private boolean kingMove(int x, int y) {
        if(Math.abs(this.X - x) <=1 && Math.abs(this.Y - 1)<= 1) {
            updateCoordinates(x, y);
            return true;
        }
        return false;
    }
}
