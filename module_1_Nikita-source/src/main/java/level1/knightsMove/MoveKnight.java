package level1.knightsMove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveKnight {
    public static void MoveInterface() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            ChessBoard board = new ChessBoard();
            System.out.println("Для выхода из задания введите \"0\"");
            System.out.println("Где вы хотите разместить фигуру коня? (например \"d4\")");
            str = reader.readLine();
            if (ChessFigure.checkWithRegExp(str)) {
                ChessFigure knight = new ChessFigure(str);
                board.setFigure(knight);
                do {
                    System.out.println("Для выхода из задания введите \"0\"");
                    System.out.println("Куда вы хотите передвинуть фигуру? (например `d4`)");
                    str = reader.readLine();
                    if (ChessFigure.checkWithRegExp(str)) {
                        board.moveFigure(knight, str);
                    }
                } while (!str.equals("0"));
            } else {
                System.out.println("Вы ввели неправильные данные");
            }
        } while (!str.equals("0"));
    }
}
