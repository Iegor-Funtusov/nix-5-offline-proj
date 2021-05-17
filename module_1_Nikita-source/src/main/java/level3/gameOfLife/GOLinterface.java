package level3.gameOfLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class GOLinterface {
    public static void GOLInterface() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            System.out.println("Для выхода из задания введите \"<\"");
            System.out.println("Как вы хотите протестировать задание? \n 1 - ручной режим \n 2 - автоматический режим");
            str = reader.readLine();
            if (str.equals("1")) {
                GOLboard board = boardInput();
                while (board == null) {
                    board = boardInput();
                }
                do {
                    System.out.println("Чтобы перейти на следующий шаг нажимайте Enter");
                    System.out.println("Для остановки введите \"0\"");
                    str = reader.readLine();
                    if (!str.equals("0")) {
                        board.gameOfLifeStep();
                    }
                } while (!str.equals("0"));

            } else if (str.equals("2")) {
                boardAuto();
            } else if (!str.equals("<")) {
                System.out.println("Вы ввели неправильные данные");
            }

        } while (!str.equals("<"));
    }

    public static GOLboard boardInput() throws IOException {
        System.out.println("Введите размерность поля. Пример: \"10*10\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = reader.readLine();
        if (checkRegExp(str, "[1-9][0-9][*][1-9][0-9]") || checkRegExp(str, "[1-9][*][1-9]")
                || checkRegExp(str, "[1-9][*][1-9][0-9]") || checkRegExp(str, "[1-9][0-9][*][1-9]")) {
            String[] delimiter = str.split("[*]");
            GOLboard board = new GOLboard(parseInt(delimiter[0]), parseInt(delimiter[1]));
            System.out.println("Введите координаты клеток, которые будут \"живы\" Пример: \"10, 10\"");
            do {
                str = reader.readLine();
                if (checkRegExp(str, "[1-9][0-9][,][ ][1-9][0-9]") || checkRegExp(str, "[1-9][,][ ][1-9]")
                        || checkRegExp(str, "[1-9][,][ ][1-9][0-9]") || checkRegExp(str, "[1-9][0-9][,][ ][1-9]")) {
                    delimiter = str.split("[,][ ]");
                    if (parseInt(delimiter[0]) > board.getN() || parseInt(delimiter[1]) > board.getM()) {
                        System.out.println("Попробуйте еще раз");
                        continue;
                    }
                    board.setCell(parseInt(delimiter[0]) - 1, parseInt(delimiter[1]) - 1);
                } else if (!str.equals("0")) {
                    System.out.println("Попробуйте еще раз");
                }
                if (!str.equals("0")) {
                    System.out.println("Введите координаты клетки или \"0\" для выхода");
                }
            } while (!str.equals("0"));
            board.print();
            return board;
        } else {
            System.out.println("Вы ввели неправильные данные");
        }
        return null;
    }

    public static void boardAuto() throws IOException {
        System.out.println("НАВИГАЦИОННЫЕ ОГНИ");
        GOLboard board = new GOLboard(9, 9);
        board.setCell(4, 3);
        board.setCell(4, 4);
        board.setCell(4, 5);
        board.setCell(3, 4);
        board.print();
        for (int i = 0; i < 12; i++) {
            board.gameOfLifeStep();
        }

        System.out.println("ВОСЬМЁРКА");
        board = new GOLboard(10, 10);
        board.setCell(1, 3);
        board.setCell(2, 2);
        board.setCell(3, 1);
        board.setCell(2, 4);
        board.setCell(4, 2);
        board.setCell(3, 5);
        board.setCell(5, 3);
        board.setCell(4, 6);
        board.setCell(6, 4);
        board.setCell(5, 7);
        board.setCell(7, 5);
        board.setCell(6, 8);
        board.setCell(7, 7);
        board.setCell(8, 6);
        board.print();
        for (int i = 0; i < 8; i++) {
            board.gameOfLifeStep();
        }
    }

    public static boolean checkRegExp(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
