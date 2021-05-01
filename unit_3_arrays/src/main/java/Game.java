import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private static final ChessBoard chessBoard = new ChessBoard();
    private static ChessFigure chessFigure = null;

    public static void play() {

        while (true) {
            update();
            chooseFigure();
            choosePosition();
            moveFigure();
        }
    }

    private static void update() {
        clearConsole();
        chessBoard.printChessBoard(chessFigure);
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void chooseFigure() {
        String figureBuilder = "";

        String message = "\nChoose figure color\n\n" +
                         "1 - white\n" +
                         "2 - black\n" +
                         "3 - exit";

        while(true) {

            System.out.println(message);
            int choice = correctIntInput(message);

            switch (choice) {
                case 1:
                    figureBuilder+="white_";
                    break;
                case 2:
                    figureBuilder+="black_";
                    break;
                case 3:
                    System.exit(0);
                default:
                    update();
                    continue;
            }
            break;
        }

        message = "\nChoose figure type\n\n" +
                    "1 - pawn\n" +
                    "2 - bishop\n" +
                    "3 - knight\n" +
                    "4 - rook\n" +
                    "5 - queen\n" +
                    "6 - king";

        update();

        while(true) {

            System.out.println(message);
            int choice = correctIntInput(message);

            switch (choice) {
                case 1:
                    figureBuilder+="pawn";
                    break;
                case 2:
                    figureBuilder+="bishop";
                    break;
                case 3:
                    figureBuilder+="knight";
                    break;
                case 4:
                    figureBuilder+="rook";
                    break;
                case 5:
                    figureBuilder+="queen";
                    break;
                case 6:
                    figureBuilder+="king";
                    break;
                default:
                    update();
                    continue;
            }
            break;
        }

        chessFigure = new ChessFigure(FigureType.valueOf(figureBuilder.toUpperCase()));

    }

    private static void choosePosition() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String position = "";
        String message = "\nChoose start position (enter coordinate - letter and number): ";

        while(true) {

            update();
            printState();
            System.out.print(message);

            try {
                position = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (position.length() != 2) {
                update();
                printState();
                continue;
            }

            position = position.toUpperCase();

            if ((chessBoard.getCoordsCharToInt().containsKey(position.charAt(0)) &&
                    chessBoard.getCoordsCharInt().contains(position.charAt(1))) ||
                    (chessBoard.getCoordsCharToInt().containsKey(position.charAt(1)) &&
                            chessBoard.getCoordsCharInt().contains(position.charAt(0)))) {

                if (Character.isDigit(position.charAt(0)))
                    position = new StringBuilder(position).reverse().toString();

                chessFigure.setPos(chessBoard.getCoordsCharToInt().get(position.charAt(0)),
                        Integer.parseInt(String.valueOf(position.charAt(1))));

            } else {
                continue;
            }

            update();
            printState();

            break;
        }

    }

    public static void moveFigure(){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String position = "";
        String message = "\nChoose position to move (enter coordinate - letter and number): ";

        boolean flag = true;

        while(true) {

            update();
            printState();

            System.out.print(message);

            try {
                position = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (position.length() != 2) {
                update();
                printState();
                continue;
            }

            position = position.toUpperCase();

            int oldPosX= chessFigure.getPosX(), oldPosY= chessFigure.getPosY();

            if ((chessBoard.getCoordsCharToInt().containsKey(position.charAt(0)) &&
                    chessBoard.getCoordsCharInt().contains(position.charAt(1))) ||
                (chessBoard.getCoordsCharToInt().containsKey(position.charAt(1)) &&
                        chessBoard.getCoordsCharInt().contains(position.charAt(0)))) {

                if (Character.isDigit(position.charAt(0)))
                    position = new StringBuilder(position).reverse().toString();

                chessFigure.move(chessBoard.getCoordsCharToInt().get(position.charAt(0)),
                        Integer.parseInt(String.valueOf(position.charAt(1))));

            } else {
                continue;
            }

            update();
            printState();

            if (oldPosX == chessFigure.getPosX() && oldPosY == chessFigure.getPosY())
                continue;

            String localMessage = "\nContinue moving?\n\n" +
                    "1 - yes\n" +
                    "2 - no";

            while(true) {

                System.out.println(localMessage);
                int choice = correctIntInput(localMessage);

                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        flag = false;
                        break;
                    default:
                        update();
                        printState();
                        continue;
                }
                break;
            }

            if (!flag) {
                chessFigure = null;
                break;
            }
        }
    }

    private static void printState() {
        System.out.println("\nCurrent figure: " + chessFigure.getFigureType());
    }

    private static int correctIntInput(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int obj;
        while (true) {
            try {
                System.out.print("\nEnter the number: ");
                obj = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                update();
                System.out.println(message);
            }
        }
        return obj;
    }
}

