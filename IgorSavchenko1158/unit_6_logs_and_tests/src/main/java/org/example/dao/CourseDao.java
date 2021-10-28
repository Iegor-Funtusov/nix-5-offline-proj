package org.example.dao;

import org.example.entity.Course;

import java.util.Collection;

public class CourseDao {

    Dao<Course> courseDao = new Dao<>();

    public String create(Course course) {
        return courseDao.create(course);
    }

    public void delete(String id) {
        courseDao.delete(id);
    }

    public void update(Course course) {
        courseDao.update(course);
    }

    public Course read(String id) {
        return courseDao.read(id);
    }

    public Collection<Course> read() {
        return courseDao.read();
    }
}
