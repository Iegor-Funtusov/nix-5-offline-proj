package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnightMoveApp {

    private static final String appName = "\nKnight Move";
    private static final ChessBoard chessBoard = new ChessBoard();
    private static Knight knight = new Knight();

    public static void run() {
        boolean flag = true;
        System.out.println();
        while (true) {
            flag = Utils.showStartMenu(appName);
            if (!flag)
                break;
            choosePosition();
            moveKnight();
        }
    }

    private static void update() {
        Utils.clearConsole();
        System.out.println(appName);
        chessBoard.printChessBoard(knight);
    }

    private static void choosePosition() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position = "";
        update();
        System.out.println();
        while(true) {

            System.out.print("Choose start position (enter coordinate - letter and number): ");

            try {
                position = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (position.length() != 2) {
                continue;
            }

            position = position.toUpperCase();

            if ((chessBoard.getCoordsCharToInt().containsKey(position.charAt(0)) &&
                    chessBoard.getCoordsCharInt().contains(position.charAt(1))) ||
                    (chessBoard.getCoordsCharToInt().containsKey(position.charAt(1)) &&
                            chessBoard.getCoordsCharInt().contains(position.charAt(0)))) {

                if (Character.isDigit(position.charAt(0)))
                    position = new StringBuilder(position).reverse().toString();

                knight.setPos(chessBoard.getCoordsCharToInt().get(position.charAt(0)),
                        Integer.parseInt(String.valueOf(position.charAt(1))));

                break;

            }
        }
    }

    private static void moveKnight(){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position = "";
        boolean flag = true;
        update();
        System.out.println();
        while(true) {

            System.out.print("Choose position to move (enter coordinate - letter and number): ");

            try {
                position = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (position.length() != 2) {
                continue;
            }

            position = position.toUpperCase();

            int oldPosX= knight.getPosX(), oldPosY= knight.getPosY();

            if ((chessBoard.getCoordsCharToInt().containsKey(position.charAt(0)) &&
                    chessBoard.getCoordsCharInt().contains(position.charAt(1))) ||
                    (chessBoard.getCoordsCharToInt().containsKey(position.charAt(1)) &&
                            chessBoard.getCoordsCharInt().contains(position.charAt(0)))) {

                if (Character.isDigit(position.charAt(0)))
                    position = new StringBuilder(position).reverse().toString();

                knight.move(chessBoard.getCoordsCharToInt().get(position.charAt(0)),
                        Integer.parseInt(String.valueOf(position.charAt(1))));

            } else {
                continue;
            }

            if (oldPosX == knight.getPosX() && oldPosY == knight.getPosY()) {
                update();
                System.out.println("\nKnight can't be moved to this cell!\n");
                continue;
            }

            update();

            while(true) {

                System.out.println("\nContinue moving?\n\n" +
                                    "1 - yes\n" +
                                    "2 - no\n");
                int choice = Utils.correctIntInput("Enter the number: ");

                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        flag = false;
                        break;
                    default:
                        update();
                        continue;
                }
                update();
                System.out.println();
                break;
            }

            if (!flag) {
                knight.setPos(0, 0);
                break;
            }
        }
    }
}
