package ua.practice.unit3;

import ua.practice.unit3.pieces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    static int currentX;
    static int currentY;
    static Piece piece;

    public static void main(String[] args) throws IOException {
        ChessBoard chessBoard = null;
        String input;
        boolean flag = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printNextOptions();
        while ((input = bufferedReader.readLine()) != null) {
            switch (input) {
                case "1":
                    if (flag) {
                        setPositionToMove(bufferedReader, chessBoard);
                        System.out.println(chessBoard);
                        break;
                    } else {
                        System.out.println("Incorrect input! Try again");
                        continue;
                    }
                case "2":
                    chessBoard = new ChessBoard();
                    System.out.println(chessBoard);
                    piece = pieceOptions(bufferedReader);
                    setPieceColour(bufferedReader, piece);
                    System.out.println(piece);
                    setPieceToPosition(bufferedReader, piece, chessBoard);
                    System.out.println(chessBoard);
                    setPositionToMove(bufferedReader, chessBoard);
                    System.out.println(chessBoard);
                    flag = true;
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Incorrect input! Try again");
            }
            printNextOptions();
        }
    }

    private static Piece pieceOptions(BufferedReader bufferedReader) throws IOException {
        System.out.println("Choose a piece:");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            switch (input.toLowerCase()) {
                case "bishop":
                    return new Bishop();
                case "king":
                    return new King();
                case "queen":
                    return new Queen();
                case "knight":
                    return new Knight();
                case "pawn":
                    return new Pawn();
                case "rook":
                    return new Rook();
                default:
                    System.out.println("Try again");
            }
        }
        return null;
    }

    private static void setPieceColour(BufferedReader bufferedReader, Piece piece) throws IOException {
        System.out.println("Choose it's colour");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            if (input.equalsIgnoreCase((COLOUR.WHITE.name()))) {
                piece.setColour(COLOUR.WHITE);
                return;
            } else if (input.equalsIgnoreCase((COLOUR.BLACK.name()))) {
                piece.setColour(COLOUR.BLACK);
                return;
            } else System.out.println("Try again");
        }
    }

    private static void setPieceToPosition(BufferedReader bufferedReader,
                                           Piece piece, ChessBoard chessBoard) throws IOException {
        System.out.println("Choose position to put in range 1A - 8H (e.g 5E): ");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            currentY = (int) input.charAt(0) - 49;
            System.out.println(currentY);
            currentX = (int) input.toUpperCase().charAt(1) - 65;
            System.out.println(currentX);
            if (chessBoard.setPosition(currentY, currentX, piece))
                return;
        }
    }

    private static void setPositionToMove(BufferedReader bufferedReader, ChessBoard chessBoard) throws IOException {
        System.out.println("Choose position to move (e.g 6E) : ");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            int toY = (int) input.charAt(0) - 49;
            System.out.println(toY);
            int toX = (int) input.toUpperCase().charAt(1) - 65;
            System.out.println(toX);
            if (chessBoard.makeTurn(currentY, currentX, toY, toX)) {
                currentY = toY;
                currentX = toX;
                return;
            }
        }
    }

    private static void printNextOptions() {
        System.out.println("Choose next options: ");
        if (piece != null)
            System.out.println("1 - continue with your piece");
        System.out.println("2 - Start with new piece");
        System.out.println("3 - stop");
    }
}
