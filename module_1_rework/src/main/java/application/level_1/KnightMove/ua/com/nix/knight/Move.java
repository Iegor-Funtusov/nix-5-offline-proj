package application.level_1.KnightMove.ua.com.nix.knight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Move {

    public void moveByUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Knight knight = new Knight();
        System.out.println("Выберите место куда поставить фигуру (d1, g5, etc.): ");
        while (knight.position == null) {
            String coordination = reader.readLine();
            try {
                knight.position = new Coordinates(coordination);
            } catch (RuntimeException e) {
                System.out.println("Введите нормальные координаты");
            }
        }
        System.out.println("Введите координаты куда переместить фигуру (d1, g5, etc.): ");
        while (true) {
            String newCoordination = reader.readLine();
            try {
                Coordinates coordinates = new Coordinates(newCoordination);
                if (knight.canMove(coordinates)) {
                    knight.position = coordinates;
                    System.out.println("Переместили фигуру");
                    break;
                } else
                    System.out.println("Неверные координаты для перемещения");
            } catch (RuntimeException e) {
                System.out.println("Введите нормальные координаты");
            }
        }
    }

    public void moveByProgram(){
        Knight knight = new Knight();
        while (knight.position == null) {
            String coordination = "a3";
            System.out.println("Фигура стоит на: " + coordination);
            knight.position = new Coordinates(coordination);

        }
        while (true) {
            String newCoordination = "c4";
            System.out.println("Перемещаем фигуру на: " + newCoordination);
            Coordinates coordinates = new Coordinates(newCoordination);
            if (knight.canMove(coordinates)) {
                knight.position = coordinates;
                System.out.println("Переместили фигуру");
                break;
            } else
                System.out.println("Неверные координаты для перемещения");
        }
    }
}



