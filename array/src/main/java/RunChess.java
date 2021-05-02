import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunChess {

    public static Board board;
    public static Figure figure;
    public static BufferedReader input;

    public static void chooseMove(Figure figure) throws IOException {
        while (true) {
            Position newPosition = choosePosition();
                System.out.println("Figure in position");
                figure.setPosition(newPosition);
                System.out.println("1 - continue moving figure");
                System.out.println("2 - pick new figure");
            System.out.println("3 - exit");
                switch (input.readLine()) {
                    case "1":
                        System.out.println("Choose coord to move your figure:");
                        continue;
                    case "2":
                        return;
                    case"3":
                        System.exit(0);
                }
            }
        }

    public static Position choosePosition() throws IOException {
        int x, y;
        String coordLetter;
        while (true) {
            coordLetter = input.readLine();
            switch (coordLetter.charAt(0)) {
                case 'A':
                    x = 0;
                    break;
                case 'B':
                    x = 1;
                    break;
                case 'C':
                    x = 2;
                    break;
                case 'D':
                    x = 3;
                    break;
                case 'E':
                    x = 4;
                    break;
                case 'F':
                    x = 5;
                    break;
                case 'G':
                    x = 6;
                    break;
                case 'H':
                    x = 7;
                    break;
                default:
                    System.out.println("Wrong coordinates, please pick coord A-H 1-8 Example: A7,B4,C1)");
                    continue;
            }
            y = Integer.parseInt(String.valueOf(coordLetter.charAt(1))) - 1;

            if (board.getSquare(x, y) != null) {
                return board.getSquare(x, y);
            }
        }
    }

    public static boolean chooseColor() throws IOException {
        System.out.println("Pick colour");
        System.out.println("1 - White");
        System.out.println("2 - Black");
        String s;
        while (true) {
            s = input.readLine();
            switch (s) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Please pick 1 or 2");
            }
        }
    }

    public static Figure pickFigure() throws IOException {
        System.out.println("Choose figure:");
        System.out.println("1 - King");
        System.out.println("2 - Queen");
        System.out.println("3 - Rook");
        System.out.println("4 - Bishop");
        System.out.println("5 - King");
        System.out.println("6 - Pawn");
        String s;
        while ((s = input.readLine()) != null) {
            switch (s) {
                case "1":
                    return new King();
                case "2":
                    return new Queen();
                case "3":
                    return new Rook();
                case "4":
                    return new Bishop();
                case "5":
                    return new Knight();
                case "6":
                    return new Pawn();
                default:
                    System.out.println("Select a number from 1 to 6 ");
            }
        }
        return null;
    }


    public static void main(String[] args) {
        board = new Board();
        System.out.println("Create a board with size A-H 1-8");
        input = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                figure = pickFigure();
                figure.setColour(chooseColor());
                System.out.println("Choose place from coord Example: A1 B7");
                figure.setPosition(choosePosition());
                System.out.println("Choose where to move your figure Example: A2 F5");
                chooseMove(figure);
            } while (true);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
