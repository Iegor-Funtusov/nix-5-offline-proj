import pieces.ChessPiece;

import java.util.Scanner;

/**
 * "Game" starts with an empty board. Number of any pieces is not limited.
 * Pieces move according to rules of chess, but cannot attack.
 */
public class Main {

    public static final ChessBoard chessBoard = new ChessBoard();

    public static void main(String[] args) {
//        System.out.println("Main.main");
//
//        ChessBoard board = new ChessBoard();
//        board.placePiece(new Pawn(ChessPiece.COLOR.BLACK), 2, 4);
//        System.out.println(board.toString());
//        System.out.println(Pawn.class.getName());

        IncredibleUserInterface();

    }

    public static void IncredibleUserInterface() {
        System.out.println("Welcome to \"Chess move\"!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chess board currently:");
            System.out.println(chessBoard);

            ChessPiece chessPiece = null;
            while ((chessPiece = selectPiece(scanner)) == null) ;

            while (!placePiece(scanner, chessPiece)) ;


        }
    }

    private static ChessPiece selectPiece(Scanner scanner) {
        System.out.println("Type name of piece you want to add, like: white Pawn");
        String color = scanner.next().toUpperCase();
        String pieceName = scanner.next();

        ChessPiece chessPiece = null;
        try {
            chessPiece = (ChessPiece) Class.forName("pieces." + pieceName)
                    .getConstructor(ChessPiece.COLOR.class)
                    .newInstance(ChessPiece.COLOR.valueOf(color));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chessPiece;
    }

    private static boolean placePiece(Scanner scanner, ChessPiece piece) {
        System.out.println("Type where to place the piece like: G5");
        char[] humanCoords = scanner.next().toCharArray();

        boolean result = false;
        try {
            result = chessBoard.placePiece(piece, humanCoords[0] - 'A',
                    Integer.parseInt(String.valueOf(humanCoords[1])) - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
