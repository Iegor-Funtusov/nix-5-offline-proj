package ua.com.alevel.app;

import ua.com.alevel.lib.CrudFactory;
import ua.com.alevel.lib.CrudService;

import java.util.Collection;

public class UserService {

    CrudService<User> userCrudService = CrudFactory.getInstance().getCurrent();

    public void create(User user) {
        userCrudService.create(user);
    }

    public void delete(String id) {
        userCrudService.delete(id);
    }

    public void update(User user) {
        userCrudService.update(user);
    }

    public User read(String id) {
        return userCrudService.read(id);
    }

    public Collection<User> read() {
        return userCrudService.read();
    }
}
