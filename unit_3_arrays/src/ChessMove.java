import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessMove {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k;
        ChessBoard board = new ChessBoard();
        do {
            System.out.println("1. Чтобы создать новую фигуру введите 1");
            System.out.println("2. Чтобы просмотреть шахматную доску введите 2");
            System.out.println("3. Чтобы просмотреть список всех фигур на доске введите 3");
            System.out.println("4. Для передвижения фигуры введите 4");
            System.out.println("0. Для выхода из приложения введите 0");
            k = Integer.parseInt(reader.readLine());

            switch (k) {
                case 1:
                    System.out.println("Какую фигуру вы хотите создать? (`K`-КОРОЛЬ; `Q`-ФЕРЗЬ; `r`-ЛАДЬЯ; `b`-СЛОН; `k`-КОНЬ; `p`-ПЕШКА)");
                    String t = reader.readLine();
                    Figures type;
                    if (stringToFigures(t) != null) {
                        type = stringToFigures(t);
                    } else {
                        System.out.println("Вы ввели неправильные данные");
                        break;
                    }
                    System.out.println("Какого цвета будет фигура? (`w`-белая; `b`-черная)");
                    String c = reader.readLine();
                    boolean color;
                    if (c.equals("w")) {
                        color = true;
                    } else if (c.equals("b")) {
                        color = false;
                    } else {
                        System.out.println("Вы ввели неправильные данные");
                        break;
                    }
                    System.out.println("Где вы хотите разместить фигуру? (например `d4`)");
                    String place = reader.readLine();
                    char[] chArr = place.toCharArray();
                    boolean is_there_a_figure = false;
                    if (chArr.length == 2 && chArr[0] >= 'a' && chArr[0] <= 'h' && chArr[1] >= '1' && chArr[1] <= '8') {
                        for (int i = 0; i < board.getChessFigures().size(); i++) {
                            if (board.getChessFigures().get(i).getCoordinates().equals(board.getChessFigures().get(i).stringToCoordinates(place))) {
                                is_there_a_figure = true;
                            }
                        }
                        if (!is_there_a_figure) {
                            board.addFigure(new ChessFigure(type, color, place));
                        } else {
                            System.out.println("На этом месте уже стоит фигура");
                            break;
                        }
                    } else {
                        System.out.println("Вы ввели неправильные данные");
                        break;
                    }
                    break;
                case 2:
                    board.print();
                    break;
                case 3:
                    System.out.println(board.getChessFigures());
                    break;
                case 4:
                    if (board.getChessFigures().isEmpty()) {
                        System.out.println("На доске ничего нет");
                        break;
                    }
                    System.out.println("Сейчас на доске находятся следующие фигуры:");
                    for (int i = 0; i < board.getChessFigures().size(); i++) {
                        System.out.print(i + 1 + " " + board.getChessFigures().get(i) + "\n");
                    }
                    System.out.println("Фигуру под каким номером вы хотите передвинуть?");
                    int n = Integer.parseInt(reader.readLine());
                    if (n > board.getChessFigures().size()) {
                        System.out.println("Вы ввели неправильные данные");
                        break;
                    }
                    System.out.println("Куда вы хотите передвинуть фигуру? (например `d4`)");
                    place = reader.readLine();
                    chArr = place.toCharArray();
                    is_there_a_figure = false;
                    if (chArr.length == 2 && chArr[0] >= 'a' && chArr[0] <= 'h' && chArr[1] >= '1' && chArr[1] <= '8') {
                        for (int i = 0; i < board.getChessFigures().size(); i++) {
                            if (board.getChessFigures().get(i).getCoordinates().equals(board.getChessFigures().get(i).stringToCoordinates(place))) {
                                is_there_a_figure = true;
                            }
                        }
                        if (!is_there_a_figure) {
                            board.moveFigure(board.getChessFigures().get(n - 1), place);
                        } else {
                            System.out.println("На этом месте уже стоит фигура");
                            break;
                        }
                    } else {
                        System.out.println("Вы ввели неправильные данные");
                        break;
                    }
                    break;
            }
        } while (k != 0);
    }

    public static Figures stringToFigures(String s) {
        switch (s) {
            case "K":
                return Figures.KING;
            case "p":
                return Figures.PAWN;
            case "r":
                return Figures.ROOK;
            case "Q":
                return Figures.QUEEN;
            case "b":
                return Figures.BISHOP;
            case "k":
                return Figures.KNIGHT;
        }
        return null;
    }
}
