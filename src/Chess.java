
import java.util.Scanner;

final class MyResult {
    private final int first;
    private final int second;

    public MyResult(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}
public class Chess {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean a = true;
        boolean b = true;
        while (b == true) {
            a = true;
            System.out.println("Выберите шахматную фигуру фигуру от 1 до 6!");
            number = ChooseFigure();
            System.out.println("Вы выбрали фигуру №" + number);
            System.out.println("Введите координаты фигуры!");
            MyResult result1 = FigureCoordinates();
            int x1 = result1.getFirst();
            int y1 = result1.getSecond();
            int x2=0;
            int y2=0;
            while (a == true) {
                boolean d=false;
                System.out.println("Координаты фигуры №" + number + ": " + x1 + " " + y1);

                System.out.println("Введите координаты, куда хотите передвинуть фигуру!");
                while (d==false) {
                    MyResult result2 = WhereGo();
                    x2 = result2.getFirst();
                    y2 = result2.getSecond();
                    d = Sdvig(number, x1, y1, x2, y2);
                }
                System.out.println("Хотите  продолжить ходить?");
                System.out.println("1- Да");
                System.out.println("2- Нет, хочу перейти ко 2 пункту");
                int vopros1 = scan.nextInt();
                if(vopros1==1 && d == true){
                    x1 = x2;
                    y1 = y2;
                } else {

                    a = false;
                    b = true;
                }
            }
        }

    }



    static int ChooseFigure() {
        System.out.println("1- Pawn");
        System.out.println("2- King");
        System.out.println("3- Queen");
        System.out.println("4- Rook");
        System.out.println("5- Knight");
        System.out.println("6- Bishop");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
    }

    public static MyResult FigureCoordinates() {
        int Coordinates_x = 0;
        int Coordinates_y = 0;
        boolean a = true;
        Scanner scan = new Scanner(System.in);
        while (a == true) {
            Coordinates_x = scan.nextInt();
            Coordinates_y = scan.nextInt();
            if (Coordinates_x < 1 || Coordinates_x > 8 || Coordinates_y < 1 || Coordinates_y > 8) {
                System.out.println("Вы ввели некоректные координаты, введите ещё раз!");
            } else {
                a = false;
            }
        }
        return new MyResult(Coordinates_x, Coordinates_y);
    }

    public static MyResult WhereGo() {
        int Coordinates_x = 0;
        int Coordinates_y = 0;
        boolean a = true;
        Scanner scan = new Scanner(System.in);
        while (a == true) {
            Coordinates_x = scan.nextInt();
            Coordinates_y = scan.nextInt();
            if (Coordinates_x < 1 || Coordinates_x > 8 || Coordinates_y < 1 || Coordinates_y > 8) {
                System.out.println("Вы ввели некоректные координаты, введите ещё раз!");
            } else {
                a = false;
            }
        }
        return new MyResult(Coordinates_x, Coordinates_y);

    }
    static boolean Sdvig(int number,int x1,int y1,int x2,int y2) {
        boolean d = true;
        switch (number) {
            case (1):
                if ((y1 + 1 == y2) || (y1 + 2 == y2) && x1 != x2) {
                    System.out.println("Вы переместили Pawn на клетку: " + x2 + " " + y2);
                } else {
                    System.out.println("Pawn не может походить на клетку: " + x2 + " " + y2);
                    d=false;

                }
                break;
            case (2):
                if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) {
                    System.out.println("Вы переместили King на клетку: " + x2 + " " + y2);
                } else {
                    System.out.println("King не может походить на клетку: " + x2 + " " + y2);
                    d=false;
                }
                break;
            case (3):
                if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1 || x1 == x2 || y1 == y2) {
                    System.out.println("Вы переместили Queen на клетку: " + x2 + " " + y2);
                } else {
                    System.out.println("Queen не может походить на клетку: " + x2 + " " + y2);
                    d=false;
                }
                break;
            case (4):
                if (x1 == x2 || y1 == y2) {
                    System.out.println("Вы переместили Rook на клетку: " + x2 + " " + y2);
                } else {
                    System.out.println("Rook не может походить на клетку: " + x2 + " " + y2);
                    d=false;
                }
                break;
            case (5):
                int dx = Math.abs(x1 - x2);
                int dy = Math.abs(y1 - y2);
                if (dx == 1 && dy == 2 || dx == 2 && dy == 1) {
                    System.out.println("Вы переместили Knight  на клетку: " + x2 + " " + y2);
                } else {
                    System.out.println("Knight не может походить на клетку: " + x2 + " " + y2);
                    d=false;
                }
                break;
            case (6):
                if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                    System.out.println("Вы переместили Bishop  на клетку: " + x2 + " " + y2);
                } else {
                    System.out.println("Bishop не может походить на клетку: " + x2 + " " + y2);
                    d=false;
                }
                break;


        }
        return d;
    }
}