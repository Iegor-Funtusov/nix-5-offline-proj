package org.example.jpa.dao;

import org.example.jpa.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDao {
    private final Session session;

    public StudentDao(Session session) {
        this.session = session;
    }

    public List<Student> getAll() {
        return session.createQuery("from Student", Student.class).list();
    }
}
