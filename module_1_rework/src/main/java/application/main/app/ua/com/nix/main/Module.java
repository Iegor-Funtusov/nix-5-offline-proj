package application.main.app.ua.com.nix.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import application.level_3.GameOfLife.ua.com.nix.Life;
import application.level_3.GameOfLife.ua.com.nix.game.Board;
import application.level_1.KnightMove.ua.com.nix.knight.Move;
import application.level_1.TriangleSquare.ua.com.nix.triangle.Square;
import application.level_1.UniqueSymbols.ua.com.nix.unique.Unique;
import application.level_2.IsValid.ua.com.nix.valid.Valid;

public class Module {

    public void run() throws IOException {
        BufferedReader builder = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Выберите уровень: \n1 - Первый \n2 - Второй \n3 - Третий \n4 - Выход");
            String level = builder.readLine();
            switch (level) {
                case "1": {
                    while (true) {
                        System.out.println("\nВыберите задачу: \n1 - Ход конём \n2 - Площадь треугольника \n3 - Уникальные символы \n4 - Выход");
                        String input1Level = builder.readLine();
                        if ("1".equals(input1Level)) {
                            while (true) {
                                System.out.println("\nВыберите запуск программы: \n1 - Ввести самому \n2 - Дефолтные значения \n3 - Выход");
                                String whatRun = builder.readLine();
                                if ("1".equals(whatRun)) {
                                    new Move().moveByUser();
                                } else if ("2".equals(whatRun)) {
                                    new Move().moveByProgram();
                                } else if ("3".equals(whatRun)) {
                                    break;
                                }
                            }
                        } else if ("2".equals(input1Level)) {
                            while (true) {
                                System.out.println("\nВыберите запуск программы: \n1 - Ввести самому \n2 - Дефолтные значения \n3 - Выход");
                                String whatRun = builder.readLine();
                                if ("1".equals(whatRun)) {
                                    System.out.println("Площадь треугольника: " + new Square().findByUser());
                                } else if ("2".equals(whatRun)) {
                                    System.out.println("Площадь треугольника: " + new Square().findByProgram());
                                } else if ("3".equals(whatRun)) {
                                    break;
                                }
                            }
                        } else if ("3".equals(input1Level)) {
                            while (true) {
                                System.out.println("\nВыберите запуск программы: \n1 - Ввести самому \n2 - Дефолтные значения \n3 - Выход");
                                String whatRun = builder.readLine();
                                if ("1".equals(whatRun)) {
                                    new Unique().findUniqueByUser();
                                } else if ("2".equals(whatRun)) {
                                    new Unique().findUniqueByProgram();
                                } else if ("3".equals(whatRun)) {
                                    break;
                                }
                            }
                        } else if ("4".equals(input1Level)) {
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    while (true) {
                        System.out.println("\nВыберите задачу: \n1 - Валидная строка \n2 - Выход");
                        String input2Level = builder.readLine();
                        if ("1".equals(input2Level)) {
                            while (true) {
                                System.out.println("\nВыберите запуск программы: \n1 - Ввести самому \n2 - Дефолтные значения \n3 - Выход");
                                String whatRun = builder.readLine();
                                if ("1".equals(whatRun)) {
                                    new Valid().findByUser();
                                } else if ("2".equals(whatRun)) {
                                    new Valid().findByProgram();
                                } else if ("3".equals(whatRun)) {
                                    break;
                                }
                            }
                        } else if ("2".equals(input2Level)) {
                            break;
                        }
                    }
                    break;
                }
                case "3": {
                    while (true) {
                        System.out.println("\nВыберите задачу: \n1 - Игра \"Жизнь\" \n2 - Выход");
                        String input3Level = builder.readLine();
                        if ("1".equals(input3Level)) {
                            while (true) {
                                System.out.println("\nВыберите запуск программы: \n1 - Ввести самому \n2 - Дефолтные значения \n3 - Выход");
                                String whatRun = builder.readLine();
                                if ("1".equals(whatRun)) {
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                                    System.out.println("Введите количество ячеек (больше 50): ");
                                    int cells;
                                    while (true) {
                                        try {
                                            cells = Integer.parseInt(reader.readLine());
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Введите число");
                                        }
                                    }
                                    new Life(cells);
                                } else if ("2".equals(whatRun)) {
                                    Life life = new Life();
                                    Board board = new Board(life.CELLS, life.CELLS);
                                    Board nextBoard = new Board(life.CELLS, life.CELLS);
                                    life.initializeBoard(board);
                                    for (int i = 0; i < 130; i++) {
                                        life.displayBoard(board);
                                        life.slow();
                                        life.calculateNextGeneration(board, nextBoard);
                                        life.transferNextToCurrent(board, nextBoard);
                                    }
                                } else if ("3".equals(whatRun)) {
                                    break;
                                }
                            }
                        } else if ("2".equals(input3Level)) {
                            break;
                        }
                    }
                    break;
                }
                case "4":
                    System.exit(0);
            }
        }
    }
}