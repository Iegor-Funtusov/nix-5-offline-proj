package org.example.jpa.dao;

import org.example.jpa.entity.Lesson;
import org.example.jpa.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LessonDao {
    private final Session session;

    public LessonDao(Session session) {
        this.session = session;
    }

    public Lesson getNextLessonByStudent(Student student) {
        String queryString = "from Lesson as L where L.dateTime > current_timestamp() and L.course.id in (select c.id from Group as g inner join Course as c on g = :group) order by L.dateTime";
        Query<Lesson> query = session.createQuery(queryString, Lesson.class);
        query.setParameter("group", student.getGroup());
        query.setMaxResults(1);

        return query.getSingleResult();
    }
}
