import java.util.Collection;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User();
        user.setLogin("qq");
        user.setPassword("11");
        userService.create(user);

        user = new User();
        user.setLogin("ww");
        user.setPassword("22");
        userService.create(user);

        Collection<User> users = userService.getAll();
        users.forEach(System.out::println);


    }
}
