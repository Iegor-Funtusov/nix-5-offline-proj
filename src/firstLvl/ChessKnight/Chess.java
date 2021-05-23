package firstLvl.ChessKnight;

import java.util.Scanner;


public class Chess {

    public static void chessKnight() {
        Scanner scan = new Scanner(System.in);
        int number = 0;


        System.out.println("Введите координаты фигуры!");
        MyResult result1 = FigureCoordinates();
        int x1 = result1.getFirst();
        int y1 = result1.getSecond();

        int x2 = 0;
        int y2 = 0;
        boolean d = false;
        System.out.println("Координаты фигуры knight: " + x1 + " " + y1);

        System.out.println("Введите координаты, куда хотите передвинуть фигуру!");
        while (d == false) {
            MyResult result2 = FigureCoordinates();
            x2 = result2.getFirst();
            y2 = result2.getSecond();
            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);
            if (dx == 1 && dy == 2 || dx == 2 && dy == 1) {
                System.out.println("Вы переместили Knight  на клетку: " + x2 + " " + y2);
                d = true;
            } else {
                System.out.println("Knight не может походить на клетку: " + x2 + " " + y2);
                d = false;
            }
        }


    }




    static MyResult FigureCoordinates() {
        int Coordinates_x = 0;
        int Coordinates_y = 0;
        boolean a = true;
        Scanner scan = new Scanner(System.in);
        while (a == true) {
            Coordinates_x = scan.nextInt();
            Coordinates_y = scan.nextInt();
            if (Coordinates_x < 1 || Coordinates_x > 8 || Coordinates_y < 1 || Coordinates_y > 8 ) {
                System.out.println("Вы ввели некоректные координаты, введите ещё раз!");
            } else {
                a = false;
            }
        }
        return new MyResult(Coordinates_x, Coordinates_y);
    }


}