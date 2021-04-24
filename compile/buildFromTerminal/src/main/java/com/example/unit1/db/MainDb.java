package main.java.com.example.unit1.db;

import main.java.com.example.unit1.model.User;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class MainDb {

    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        this.users.add(user);
    }

    public void updateUser(User user){
        for(int i = 0; i < this.users.size(); i++){
            if(this.users.get(i).getId().equals(user.getId())){
                this.users.set(i, user);
                break;
            }
        }
    }

    public List<User> getAllUsers(){
        return this.users;
    }

    public void deleteUserById(String id){
        this.users.removeIf(x -> x.getId().equals(id));
    }
}
