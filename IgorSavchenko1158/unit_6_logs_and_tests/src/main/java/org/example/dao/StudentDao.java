package org.example.dao;

import org.example.entity.Student;

import java.util.Collection;

public class StudentDao {

    Dao<Student> studentDao = new Dao<>();

    public String create(Student student) {
        return studentDao.create(student);
    }

    public void delete(String id) {
        studentDao.delete(id);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public Student read(String id) {
        return studentDao.read(id);
    }

    public Collection<Student> read() {
        return studentDao.read();
    }
}
