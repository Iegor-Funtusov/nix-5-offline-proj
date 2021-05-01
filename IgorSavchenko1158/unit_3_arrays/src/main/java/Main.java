import pieces.ChessPiece;

import java.util.Scanner;

public class Main {

    public static final ChessBoard chessBoard = new ChessBoard();

    public static void main(String[] args) {
        incredibleUserInterface();
    }

    public static void incredibleUserInterface() {
        System.out.println("Welcome to \"Chess move\"!");

        Scanner scanner = new Scanner(System.in);

        ChessPiece chessPiece;
        while (true) {
            while ((chessPiece = getPiece(scanner)) == null) {
                System.out.println("Wrong input, or even worse");
            }

            while (!placePiece(chessPiece, scanner)) {
                System.out.println("Wrong input, I think");
            }

            System.out.println(chessBoard);
            X:
            while (true) {
                while (!movePiece(scanner)) {
                    System.out.println("Wrong input it seems");
                }

                System.out.println(chessBoard);
                System.out.println("Continue moving this piece? Y/n");
                switch (scanner.nextLine().toUpperCase()) {
                    case "N":
                        break X;
                    case "Y":
                    default:
                        break;
                }
            }
        }
    }

    private static ChessPiece getPiece(Scanner scanner) {
        System.out.println("To select new piece, enter its name, e.g. Black Pawn");
        String color = scanner.next().toUpperCase();
        String name = scanner.next();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        scanner.nextLine();

        ChessPiece chessPiece = null;

        try {
            chessPiece = (ChessPiece) Class.forName("pieces." + name)
                    .getConstructor(ChessPiece.COLOR.class)
                    .newInstance(ChessPiece.COLOR.valueOf(color));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chessPiece;
    }

    private static boolean placePiece(ChessPiece chessPiece, Scanner scanner) {
        System.out.println("To place the piece, enter coordinates like this: G5");

        char[] coordinates = scanner.next().toCharArray();
        scanner.nextLine();

        boolean result = false;

        try {
            result = chessBoard.placePiece(chessPiece, coordinates[0] - 'A',
                    Integer.parseInt(String.valueOf(coordinates[1])) - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean movePiece(Scanner scanner) {
        System.out.println("To move the piece, enter destination coordinates:");

        char[] coordinates = scanner.next().toCharArray();
        scanner.nextLine();

        boolean result = false;

        try {
            result = chessBoard.movePiece(coordinates[0] - 'A',
                    Integer.parseInt(String.valueOf(coordinates[1])) - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
