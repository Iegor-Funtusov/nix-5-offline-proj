package ua.com.alevel.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SOLID
public class AppMain {

    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("1 - Создать \n2 - Прочитать \n3 - Перезаписать \n4 - Удалить \n5 - Выйти");
            String s = reader.readLine();
            switch (s) {
                case "1": {
                    System.out.println("Введите имя и возраст пользователя: ");
                    User user = new User().setName(reader.readLine()).setAge(Integer.parseInt(reader.readLine()));
                    userService.create(user);
                    break;
                }
                case "2": {
                    System.out.println(userService.read());
                    break;
                }
                case "3": {
                    System.out.println("Введите ID чтобы перезаписать:");
                    String id = reader.readLine();
                    User currentUser;
                    if ((currentUser = userService.read(id)) == null) {
                        System.out.println("Не тот ID");
                        break;
                    }
                    System.out.println("Введите новые имя и возраст:");
                    userService.update(currentUser.setName(reader.readLine()).setAge(Integer.parseInt(reader.readLine())));
                    break;
                }
                case "4": {
                    System.out.println("Введите ID для удаления:");
                    try {
                        userService.delete(reader.readLine());
                    } catch (RuntimeException ex) {
                        System.out.println("Проблема в: " + ex.getMessage());
                    }
                    break;
                }
                case "5": {
                    break;
                }
            }
        }
    }
}
