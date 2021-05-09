import java.util.Collection;

public class UserService {
    CrudServiceInterface<User> userCrudService = CrudFactory.getInstance().getCurrent();

    public void create(User user) {
        userCrudService.create(user);
    }

    public void delete(String id) {
        userCrudService.delete(id);
    }

    public void update(User user) {
        userCrudService.update(user);
    }

    public User get(String id) {
        return userCrudService.get(id);
    }

    public Collection<User> getAll() {
        return userCrudService.getAll();
    }
}
