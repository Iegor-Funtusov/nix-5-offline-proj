package ua.com.davidenko.app;

import ua.com.davidenko.lib.CrudFactory;
import ua.com.davidenko.lib.CrudService;
import java.util.Collection;

public class UserService  implements CrudService<User>{

    CrudService<User> userCrudService;

    public UserService(String crudName) {
        this.userCrudService = CrudFactory.getInstance().getCurrent(crudName);
    }


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
        return (User) userCrudService.read(id);
    }

    public Collection<User> read() {
        return userCrudService.read();
    }
}