package org.example;

import org.example.jpa.dao.LessonDao;
import org.example.jpa.dao.StudentDao;
import org.example.jpa.entity.*;
import org.example.jpa.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.populateDatabase();
        List<Student> allStudents = new StudentDao(HibernateUtil.getSessionFactory().openSession()).getAll();
        System.out.println("allStudents = " + allStudents);
        Lesson nextLessonByStudent = new LessonDao(HibernateUtil.getSessionFactory().openSession()).getNextLessonByStudent(allStudents.get(0));
        System.out.println("nextLessonByStudent = " + nextLessonByStudent);
    }
}
