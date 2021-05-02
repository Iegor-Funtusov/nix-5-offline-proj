package ua.com.alevel;
import java.util.Scanner;

public class Move {
    static Scanner user_input = new Scanner(System.in);


    public static void main(String[] args) {
        Board myChessboard = new Board();


        while (myChessboard.getGameRunning()) {

            myChessboard.printBoard();
            myChessboard.move();

        }
    }
}
