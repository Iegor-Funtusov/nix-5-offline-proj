package ua.com.nix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateStarter {
    public void start() {
        DateOperations dateOperations = new DateOperations();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("""
                    Выберите функцию:
                    1 - Добавление к дате
                    2 - Вычетание из даты
                    3 - Разница дат
                    4 - Сравнение дат
                    0 - Выход""");

        try {

            String read;

            while ((read = reader.readLine()) != null) {
                switch (read) {
                    case "1" -> dateOperations.add();
                    case "2" -> dateOperations.minus();
                    case "3" -> dateOperations.difference();
                    case "4" -> dateOperations.compare();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Извините, вы ввели неправильное значение " + read);
                }
            }
        }
        catch (IOException | IllegalStateException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
