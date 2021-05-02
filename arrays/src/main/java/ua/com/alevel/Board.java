package ua.com.alevel;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private Boolean gamerun;
    private AbstractPiece[][] chessboard = new AbstractPiece[numOfRowsAndCols][numOfRowsAndCols];// [row][column]
    Scanner user_input = new Scanner(System.in);
    private static final int numOfRowsAndCols = 8;
    private static int srcRow, srcCol, destRow, destCol;
    private static Boolean whitesTurnToMove;
    private static Boolean invalidMove = false;
    // Holds string with the user input for move instructions
    String move;


    public Board() {

        initialiseBoard(chessboard);
        gamerun = true;

    }


    public Boolean getGameRunning() {
        return this.gamerun;
    }


    private static void initialiseBoard(AbstractPiece[][] chessboard) {


        for (int row = 0; row < chessboard.length; row++) {
            for (int col = 0; col < chessboard[row].length; col++) {
                if (row == 0) {
                    switch (col) {
                        case 0:
                            chessboard[row][col] = new Rook(false);
                            break;
                        case 1:
                            chessboard[row][col] = new Knight(false);
                            break;
                        case 2:
                            chessboard[row][col] = new Elephant(false);
                            break;
                        case 3:
                            chessboard[row][col] = new Queen(false);
                            break;
                        case 4:
                            chessboard[row][col] = new King(false);
                            break;
                        case 5:
                            chessboard[row][col] = new Elephant(false);
                            break;
                        case 6:
                            chessboard[row][col] = new Knight(false);
                            break;
                        case 7:
                            chessboard[row][col] = new Rook(false);
                            break;
                    }
                } else if (row == 1) {
                    chessboard[row][col] = new Pawn(false);
                } else if (row == 6) {
                    chessboard[row][col] = new Pawn(true);
                } else if (row == 7) {
                    switch (col) {
                        case 0:
                            chessboard[row][col] = new Rook(true);
                            break;
                        case 1:
                            chessboard[row][col] = new Knight(true);
                            break;
                        case 2:
                            chessboard[row][col] = new Elephant(true);
                            break;
                        case 3:
                            chessboard[row][col] = new Queen(true);
                            break;
                        case 4:
                            chessboard[row][col] = new King(true);
                            break;
                        case 5:
                            chessboard[row][col] = new Elephant(true);
                            break;
                        case 6:
                            chessboard[row][col] = new Knight(true);
                            break;
                        case 7:
                            chessboard[row][col] = new Rook(true);
                            break;
                    }
                } else {
                    chessboard[row][col] = null;
                }
            }
        }

        Random rand = new Random();
        whitesTurnToMove = rand.nextBoolean();

    }


    public void printBoard() {


        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        for (int row = 0; row < chessboard.length; row++) {
            System.out.print(8 - row + ".\t");
            for (int col = 0; col < chessboard[row].length; col++) {
                if (chessboard[row][col] != null) {
                    chessboard[row][col].draw();
                    System.out.print("\t");

                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }


    private boolean moveValid() {



        if (srcRow < 0 || srcRow > 7 || srcCol < 0 || srcCol > 7 || destRow < 0
                || destRow > 7 || destCol < 0 || destCol > 7) {
            System.out.println("Ход за пределами доски");
            return false;
        }


        if ((chessboard[srcRow][srcCol].isWhite && !whitesTurnToMove)
                || (!chessboard[srcRow][srcCol].isWhite && whitesTurnToMove)) {
            System.err.println("Не ваш ход");
            return false;
        }

        if (!chessboard[srcRow][srcCol].isMoveValid(srcRow, srcCol, destRow,
                destCol)) {
            System.err.println("Фигура не может так ходить");
            return false;
        }

        if (chessboard[destRow][destCol] == null) {
            return true;
        }


        if (chessboard[srcRow][srcCol].isWhite
                && chessboard[destRow][destCol].isWhite) {
            System.err.println("Белая фигура не может так походить");
            return false;
        }


        if (!chessboard[srcRow][srcCol].isWhite
                && !chessboard[destRow][destCol].isWhite) {
            System.err.println("Черная фигура не может так походить");
            return false;
        }

        return true;

    }





    public void move() {



        if (invalidMove) {
            System.err.println("Ход невозможен. Попробуйте еще раз:");
            invalidMove = false;
        }

        else if (whitesTurnToMove) {
            System.out
                    .println("___________________________________________________\n"
                            + "Ходят белые\n"
                            + "___________________________________________________\n");
        } else {
            System.out
                    .println("___________________________________________________\n"
                            + "Ходят черные\n"
                            + "___________________________________________________\n");
        }

        move = user_input.nextLine();

        if (move.equalsIgnoreCase("Выход")) {
            gamerun = false;
            System.out.println("Спасибо за игру!");
            return;
        }


        String lowerCase = move.toLowerCase();
        String[] components = lowerCase.split(" ");



        srcRow = 7 - (components[0].charAt(1) - '1');
        srcCol = components[0].charAt(0) - 'a';
        destRow = 7 - (components[2].charAt(1) - '1');
        destCol = components[2].charAt(0) - 'a';

        if (moveValid()) {

            chessboard[destRow][destCol] = chessboard[srcRow][srcCol];
            chessboard[srcRow][srcCol] = null;
            whitesTurnToMove = !whitesTurnToMove;
        } else {
            invalidMove = true;
            move();

        }

    }
}
