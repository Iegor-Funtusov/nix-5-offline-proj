import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AppMain {
    public static void main(String[] args) throws IOException {
        UserService userService = new UserService();
        User user;
        List<User> users;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k;

        do {
            System.out.println("1. Чтобы создать нового пользователя введите 1");
            System.out.println("2. Чтобы просмотреть всех пользователей введите 2");
            System.out.println("3. Чтобы посмотреть информацию о конкретном пользователе введите 3");
            System.out.println("4. Чтобы обновить информацию о пользователе введите 4");
            System.out.println("5. Для удаления пользователя введите 5");
            System.out.println("0. Для выхода из приложения введите 0");
            k = parseInt(reader.readLine());
            users = (ArrayList<User>) userService.getAll();

            switch (k) {
                case 1:
                    System.out.println("Введите логин");
                    String l = reader.readLine();
                    System.out.println("Введите пароль");
                    String p = reader.readLine();
                    userService.create(createUser(l, p));
                    System.out.println();
                    break;
                case 2:
                    users = (ArrayList<User>) userService.getAll();
                    users.forEach(System.out::println);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Введите номер пользователя которого хотите просмотреть");
                    int n = parseInt(reader.readLine());
                    System.out.println(userService.get(users.get(n).getId()));
                    break;
                case 4:
                    System.out.println("Введите номер пользователя, информацию о котором хотите обновить");
                    n = parseInt(reader.readLine());
                    user = userService.get(users.get(n).getId());
                    System.out.println("Введите логин");
                    l = reader.readLine();
                    System.out.println("Введите пароль");
                    p = reader.readLine();
                    user.setLogin(l);
                    user.setPassword(p);
                    userService.update(user);
                    break;
                case 5:
                    System.out.println("Введите номер пользователя которого хотите удалить");
                    n = parseInt(reader.readLine());
                    userService.delete(users.get(n).getId());
                    break;
            }
        } while (k != 0);
    }

    public static User createUser(String log, String pass) {
        User user = new User();
        user.setLogin(log);
        user.setPassword(pass);
        return user;
    }


}
