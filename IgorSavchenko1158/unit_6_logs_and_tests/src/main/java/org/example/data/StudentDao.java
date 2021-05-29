package org.example.data;

import java.util.Collection;

public class StudentDao {

    Dao<Student> dao = new Dao<>();

    public void create(Student dog) {
        dao.create(dog);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public void update(Student dog) {
        dao.update(dog);
    }

    public Student read(String id) {
        return dao.read(id);
    }

    public Collection<Student> read() {
        return dao.read();
    }
}
