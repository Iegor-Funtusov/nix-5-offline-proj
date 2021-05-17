package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static ua.com.nix.KnightMove.horseMove;
import static ua.com.nix.UniqueNumbers.findUniqueNumbers;
import static ua.com.nix.TriangleSquare.findTriangleSquare;
import static ua.com.nix.ValidString.stringValidationChecking;

public class MainClass {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            offer();
            String read = reader.readLine();
            switch (read) {
                case "0":
                    System.exit(0);
                case "1":
                    System.out.println("Выберите задачу: \n1 - Задача про уникальные числа в массиве; \n" +
                            "2 - Ход коня по шахматной доске; \n3 - Площадь треугольника по координатам его вершин");
                    String forFirstLevel = reader.readLine();
                    if (forFirstLevel.equals("1"))
                        findUniqueNumbers();
                    else if (forFirstLevel.equals("2"))
                        horseMove();
                    else if (forFirstLevel.equals("3"))
                        findTriangleSquare();
                    break;
                case "2":
                    stringValidationChecking();
                    break;
                case "3":
                    System.out.println("3 задача: ");
                    startOfGame();
                    break;
                default:
                    System.out.println("Вы ввели что-то неправильное, но Вы можете попробовать ещё раз.");
                    break;
            }
        }

    }

    public static void offer(){

        System.out.println("Выберите уровень задания: \n1 - 1 уровень (3 задачи); \n" +
                "2 - 2 уровень (1 задача - валидность введёной строки на закрытие скобок); \n" +
                "3 - 3 уровень (1 задача - игра в жизнь); \n" +
                "0 - Выйти из программы.");

    }

    public static void startOfGame(){
        GameOfLife gameOfLife = new GameOfLife(8, 8);
        gameOfLife.setAlive(2, 2);
        gameOfLife.setAlive(3,2);
        gameOfLife.setAlive(4,2);
        gameOfLife.setAlive(5,3);
        gameOfLife.setAlive(6,3);

        gameOfLife.setDead(3,3);
        gameOfLife.setDead(4,3);
        gameOfLife.setDead(5,4);
        gameOfLife.setDead(6,5);

        gameOfLife.printBoard();
        gameOfLife.move();

        gameOfLife.printBoard();
        gameOfLife.move();

        gameOfLife.printBoard();

        gameOfLife.move();
        gameOfLife.printBoard();
    }

}
