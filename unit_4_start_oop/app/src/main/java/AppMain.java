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

        List<User> users = (List<User>) userService.getAll();
        users.forEach(System.out::println);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals("ww")) {
                userService.delete(users.get(i).getId());
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        users = (List<User>) userService.getAll();
        users.forEach(System.out::println);
    }
}
