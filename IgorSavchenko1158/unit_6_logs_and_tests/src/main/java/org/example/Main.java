package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Student;
import org.example.dao.StudentDao;

public class Main {
        private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.warn("Priehali");

        StudentDao studentDao = new StudentDao();
        String id = studentDao.create(new Student().setFirstName("Vasya").setLastName("Goblina").setAddress("Kharkiv"));
        studentDao.create(new Student().setFirstName("Dasha").setLastName("Goblina").setAddress("Kharkiv2"));

        studentDao.read().forEach(System.out::println);
        System.out.println(studentDao.read(id));

        logger.warn("Uehali");
    }
}
