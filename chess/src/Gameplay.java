import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gameplay {
    static int xCoordinate;
    static int yCoordinate;
    private static ChessFigure figure = new ChessFigure();
    static Gameplay gameplay = new Gameplay();
    public static ChessField field = new ChessField();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Gameplay.figureSelection(bufferedReader, figure);
        setPieceColour(bufferedReader, figure);
        setFigureToPosition(bufferedReader, figure, field);
        continueMoveOrNot(bufferedReader, figure);

    }

    private static ChessFigure figureSelection(BufferedReader bufferedReader, ChessFigure figure) throws IOException {
        System.out.println("Choose a figure: bishop, king, queen, knight, pawn, rook");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            switch (input.toLowerCase()) {
                case "bishop":
                    figure.setBishop(1);
                    return figure;
                case "king":
                    figure.setKing(1);
                    return figure;
                case "queen":
                    figure.setQueen(1);
                    return figure;
                case "knight":
                    figure.setKnight(1);
                    return figure;
                case "pawn":
                    figure.setPown(1);
                    return figure;
                case "rook":
                    figure.setRook(1);
                    return figure;
                default:
                    System.out.println("Try again");
            }
        }
        return null;
    }

    private static void setPieceColour(BufferedReader bufferedReader, ChessFigure figure) throws IOException {
        System.out.println("Choose it's colour:White or Black");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            switch (input.toLowerCase()) {
                case "white":
                    figure.setChessColour(true);
                    return;
                case "black":
                    figure.setChessColour(false);
                    return;
                default:
                    System.out.println("Try again");
            }
        }
    }

    private static void setFigureToPosition(BufferedReader bufferedReader, ChessFigure figure, ChessField chessField) throws IOException {
        System.out.println("Choose X coordinate and Y coordinate for move figure");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            xCoordinate = Integer.parseInt(input);
            yCoordinate = Integer.parseInt(bufferedReader.readLine());
            if (chessField.checkSpace(xCoordinate, yCoordinate)) {
                chessField.fillField(xCoordinate, yCoordinate, figure);
            } else {
                System.out.println("Incorrect coordinates, try again");
                continue;
            }
            return;
        }
    }

    private static void continueMoveOrNot(BufferedReader bufferedReader, ChessFigure figure) throws IOException {
        System.out.println("You want to continue moving the figure?");
        System.out.println("Yes or Not");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            switch (input.toLowerCase()) {
                case "yes":
                    moveFigure(bufferedReader, figure);
                    continueMoveOrNot(bufferedReader, figure);
                    continue;
                case "not":
                    Gameplay.figureSelection(bufferedReader, figure);
                    setPieceColour(bufferedReader, figure);
                    setFigureToPosition(bufferedReader, figure, field);
                    continueMoveOrNot(bufferedReader, figure);
                    return;
                default:
                    System.out.println("Incorrect answer");
            }
        }
    }

    public static void moveFigure(BufferedReader bufferedReader, ChessFigure figure) throws IOException {
        System.out.println("Choose X coordinate and Y coordinate for move figure");
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            int tempX = Integer.parseInt(input);
            int tempY = Integer.parseInt(bufferedReader.readLine());
            if (field.checkToMove(xCoordinate, yCoordinate, tempX, tempY)) {
                xCoordinate = tempX;
                yCoordinate = tempY;
                return;
            }
            System.out.println("Incorrect coordinates");
            return;
        }
    }

}

