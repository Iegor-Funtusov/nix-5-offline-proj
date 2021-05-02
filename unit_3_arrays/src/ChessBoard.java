import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    private final String[][] board = new String[8][8];
    private final List<ChessFigure> chessFigures = new ArrayList<>();

    public List<ChessFigure> getChessFigures() {
        return chessFigures;
    }

    public ChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = "0";
                } else {
                    board[i][j] = "#";
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    System.out.print(8 - i + "|| ");
                }
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\t" + "=============================");
        System.out.println("\t" + "a" + "\t" + "b" + "\t" + "c" + "\t" + "d" + "\t" + "e" + "\t" + "f" + "\t" + "g" + "\t" + "h");
    }

    public void setFigure(ChessFigure figure) {
        setCell(figure.getCoordinates(), figure.getType(), figure.isColor());
        print();
    }

    public void moveFigure(ChessFigure figure, String str){
        if(figure.canMove(str)){
            deleteFigure(figure.getCoordinates());
            figure.setCoordinatesByString(str);
            setFigure(figure);
        }
    }

    public void addFigure(ChessFigure figure){
        chessFigures.add(figure);
        setFigure(figure);
    }

    public void setCell(Coordinates coordinates, Figures figure, boolean color) {
        board[coordinates.getX()][coordinates.getY()] = figureToString(figure, color);
    }

    private String figureToString(Figures figure, boolean color) {
        String str = "";
        if (color) {
            str += "w";
        } else {
            str += "b";
        }
        switch (figure) {
            case KING:
                return str + "K";
            case PAWN:
                return str + "p";
            case ROOK:
                return str + "r";
            case QUEEN:
                return str + "Q";
            case BISHOP:
                return str + "b";
            case KNIGHT:
                return str + "k";
        }
        return "";
    }

    private void setDefaultValue(Coordinates coordinates) {
        if ((coordinates.getX() + coordinates.getY()) % 2 == 0) {
            board[coordinates.getX()][coordinates.getY()] = "0";
        } else {
            board[coordinates.getX()][coordinates.getY()] = "#";
        }
    }

    public void deleteFigure(Coordinates coordinates) {
        if (!board[coordinates.getX()][coordinates.getY()].equals("0")
                && !board[coordinates.getX()][coordinates.getY()].equals("#")) {
            setDefaultValue(coordinates);
        } else {
            System.out.println("Что-то пошло не так!!! Мы не смогли переместить фигуру");
        }
    }
}
