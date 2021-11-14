package ua.com.app;

import ua.com.lib.CrudFactory;
import ua.com.lib.CrudService;
import ua.com.lib.ObjectCrudService;

import java.util.Collection;

public class UserService {
    CrudService<User> userCrudService = CrudFactory.getInstance().getCurrent();

    public void create (User user){
        userCrudService.create(user);
    }

    public User read(String id){
        return userCrudService.read(id);
    }

    public Collection<User> readAll(){
        return userCrudService.readAll();
    }

    public void update(User user){
        userCrudService.update(user);
    }

    public void delete (String id){
        userCrudService.delete(id);
    }

    public void size(){
        System.out.println(ObjectCrudService.size());
    }
}
