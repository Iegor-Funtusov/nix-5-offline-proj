package nix;

import nix.pieces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessMain {
    public static void main(String[] args) {
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));

        String typePieces = null;
        String coordsCreate = null;
        String coordsMove = null;
        String colorPiece = null;
        while (true) {
            boolean correctInput = true;
            System.out.println("Choose type chess pieces (pawn, king, knight, pawn, queen, rook, bishop)");
            try {
                typePieces = enter.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Piece currentPiece = createPiece(typePieces);

            System.out.println("Enter color like WHITE or BLACK");
            try {
                colorPiece = enter.readLine();
                colorPiece = colorPiece.toUpperCase();
                currentPiece.pieceColor = chooseColor(colorPiece);
            } catch (Exception e) {
                e.printStackTrace();
            }

            while (correctInput) {
                System.out.println("Enter place coords(example A5, B4 ...)");
                try {
                    coordsCreate = enter.readLine();
                    currentPiece.pieceCoordinate = new PieceCoordinate(coordsCreate);
                    correctInput = false;
                } catch (Exception e) {
                    System.out.println("Wrong coords!!!");
                    e.printStackTrace();
                }
            }
            System.out.println("We create piece on " + coordsCreate);

            while (true) {
                System.out.println("Where are we moving?(example A6, B3 ...)");
                PieceCoordinate moveCoords = null;
                try {
                    coordsMove = enter.readLine();
                    moveCoords = new PieceCoordinate(coordsMove);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (moveCoords != null && currentPiece.isCanMove(moveCoords)) {
                    currentPiece.pieceCoordinate = moveCoords;
                    System.out.println("We place piece on " + coordsMove);
                } else {
                    System.out.println("Wrong coords!");
                }
                String choose = "1";
                System.out.println("1 - continue\n2 - create new piece");
                try {
                    choose = enter.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (choose.equals("2")) {
                    break;
                }
            }
        }
    }

    private static Piece.PieceColor chooseColor(String colorPiece) throws Exception {
        if (colorPiece.equals("WHITE")) {
            return Piece.PieceColor.WHITE;
        } else if (colorPiece.equals("BLACK")) {
            return Piece.PieceColor.BLACK;
        }
        throw new Exception("wrong color");
    }

    private static Piece createPiece(String typePieces) {
        switch (typePieces) {
            case "pawn":
                return new Pawn();
            case "king":
                return new King();
            case "knight":
                return new Knight();
            case "queen":
                return new Queen();
            case "rook":
                return new Rook();
            case "bishop":
                return new Bishop();
            default:
                return null;
        }
    }
}
