package ua.practice.unit3;

import ua.practice.unit3.pieces.*;

public class ChessBoard {
    private static final int BOUNDS = 8;
    private final Position[][] board = new Position[BOUNDS][BOUNDS];


    public ChessBoard() {
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[7 - i][j] = new Position(i, j);
            }
        }
    }


    public boolean makeTurn(int y, int x, int toY, int toX) {
        if (isPositionInBounds(toY, toX)) {
            Piece piece = board[7 - y][x].getPiece();
            if (piece.move(y, x, toY, toX)) {
                board[7 - toY][toX].setPiece(piece);
                board[7 - y][x].setPiece(null);
                return true;
            } else {
                System.out.println("Impossible to make this turn");
                return false;
            }
        }
        return false;
    }

    public Position getPosition(int y, int x) {
        return board[7 - y][x];
    }

    public boolean setPosition(int y, int x, Piece piece) {
        if (isPositionInBounds(y, x)) {
            board[7 - y][x].setPiece(piece);
            return true;
        } else return false;
    }

    private boolean isPositionInBounds(int y, int x) {
        return (y <= 7 && y >= 0 || x <= 7 && x >= 0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < BOUNDS; i++) {
            for (int j = 0; j < BOUNDS; j++) {
                stringBuilder.append(board[i][j]).append("\t");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
