package org.example.jpa;

import org.example.jpa.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.Set;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = configureSessionFactory();

    private static SessionFactory configureSessionFactory() {
        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public static void populateDatabase() {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();

                Group group = new Group();
                group.setName("Group 1");
                session.save(group);
                Group group2 = new Group();
                group2.setName("Group 2");
                session.save(group2);

                Student student = new Student();
                student.setFirstName("Ivan");
                student.setLastName("Ivanov");
                student.setGroup(group);
                session.save(student);

                Student student2 = new Student();
                student2.setFirstName("Bob");
                student2.setLastName("Bobov");
                student2.setGroup(group);
                session.save(student2);

                Course course = new Course();
                course.setName("Course 1");
                course.setDescription("Very nice course 1");
                session.save(course);

                group.setCourses(Set.of(course));
                session.save(group);

                Topic topic = new Topic();
                topic.setName("Topic 1");
                session.save(topic);

                Teacher teacher = new Teacher();
                teacher.setFirstName("Vasya");
                teacher.setLastName("Vasyanov");
                session.save(teacher);

                Lesson lesson = new Lesson();
                lesson.setCourse(course);
                lesson.setDateTime(LocalDateTime.parse("2022-07-31T10:15:30"));
                lesson.setTopic(topic);
                lesson.setTeacher(teacher);
                session.save(lesson);

                Lesson lesson2 = new Lesson();
                lesson2.setCourse(course);
                lesson2.setDateTime(LocalDateTime.parse("9999-07-31T10:15:30"));
                lesson2.setTopic(topic);
                lesson2.setTeacher(teacher);
                session.save(lesson2);

                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }
}
