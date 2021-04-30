import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessMove {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Выберите фигуру: ");
            String piece = reader.readLine();
            ChessPiece newPiece = createPiece(piece);
            System.out.println("Выберите цвет фигуры: ");
            String color = reader.readLine();
            newPiece.color = chooseColor(color);
            System.out.println("Выберите место куда поставить фигуру: ");
            while (newPiece.position == null) {
                String coord = reader.readLine();
                try {
                    newPiece.position = new Coordinates(coord);
                } catch (RuntimeException e) {
                    System.out.println("Введите нормальные координаты");
                }
            }
            while (true) {
                System.out.println("Введите координаты куда переместить фигуру");
                while (true) {
                    String newCoord = reader.readLine();
                    try {
                        Coordinates coordinates = new Coordinates(newCoord);
                        if (newPiece.canMove(coordinates)) {
                            newPiece.position = coordinates;
                            System.out.println("Переместили фигуру");
                            break;
                        } else
                            System.out.println("У вас всё плохо, введите нормально");
                    } catch (RuntimeException e) {
                        System.out.println("Введите нормальные координаты");
                    }
                }
                System.out.println("Хотите продолжить перемещать фигуру или поставить новую? Ответьте \"да\" или \"нет\"");
                String continueOrBack = reader.readLine();
                if (!yerOrNo(continueOrBack)) {
                    break;
                }
            }

        }
    }

    public static boolean yerOrNo(String str) {
        switch (str.toLowerCase()) {
            case "+":
            case "yes":
            case "да":
            case "y":
                return true;
            case "-":
            case "no":
            case "нет":
            case "n":
                return false;
            default:
                throw new RuntimeException("Неправильный ответ)");
        }
    }

    public static ChessPiece.Color chooseColor(String color) {
        switch (color.toLowerCase()) {
            case "белый":
            case "white":
                return ChessPiece.Color.WHITE;
            case "черный":
            case "black":
                return ChessPiece.Color.BLACK;
            default:
                throw new RuntimeException("Неправильный цвет");
        }
    }

    public static ChessPiece createPiece(String chessPiece) {
        switch (chessPiece.toLowerCase()) {
            case "pawn":
            case "пешка":
                return new Pawn();
            case "rook":
            case "тура":
            case "ладья":
                return new Rook();
            case "knight":
            case "конь":
                return new Knight();
            case "bishop":
            case "слон":
                return new Bishop();
            case "queen":
            case "королева":
                return new Queen();
            case "king":
            case "король":
                return new King();
            default:
                throw new RuntimeException("Неправильная фигура");
        }
    }
}
