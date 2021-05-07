import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        CrudService<User> userCrudService = new CrudService<>();
        User user = new User();
        user.setLogin("qq");
        user.setPassword("11");
        userCrudService.create(user);

        user = new User();
        user.setLogin("ww");
        user.setPassword("22");
        userCrudService.create(user);

        List<User> users = userCrudService.getAll();
        users.forEach(System.out::println);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals("ww")) {
                userCrudService.delete(users.get(i).getId());
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        users = userCrudService.getAll();
        users.forEach(System.out::println);
    }
}
