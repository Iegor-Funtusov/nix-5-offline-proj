package org.example.dao;

import org.example.entity.StudentInCourse;

import java.util.Collection;

public class StudentInCourseDao {

    Dao<StudentInCourse> studentInCourseDao = new Dao<>();

    public String create(StudentInCourse student) {
        return studentInCourseDao.create(student);
    }

    public void delete(String id) {
        studentInCourseDao.delete(id);
    }

    public void update(StudentInCourse dog) {
        studentInCourseDao.update(dog);
    }

    public StudentInCourse read(String id) {
        return studentInCourseDao.read(id);
    }

    public Collection<StudentInCourse> read() {
        return studentInCourseDao.read();
    }
}
