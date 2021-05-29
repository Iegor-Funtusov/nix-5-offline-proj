package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.controller.UniversityController;
import org.example.entity.StudentInCourse;
import org.example.entity.Course;
import org.example.entity.Student;

public class Main {
        private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.warn("Main.main");

        var uni = getExampleController();

        System.out.println("Students:");
        uni.readStudent().forEach(System.out::println);
        System.out.println("Courses");
        uni.readCourse().forEach(System.out::println);

        System.out.println("All courses of Stud0:");
        uni.readAllCoursesByStudent("Student0").forEach(System.out::println);

        System.out.println("All students at Course0:");
        uni.readAllStudentsByCourse("Course0").forEach(System.out::println);

        System.out.println("Deleting course0");
        uni.deleteCourse("Course0");

        System.out.println("All courses of Stud0:");
        uni.readAllCoursesByStudent("Student0").forEach(System.out::println);

        System.out.println("All students at Course1:");
        uni.readAllStudentsByCourse("Course1").forEach(System.out::println);

        System.out.println("Deleting Student0");
        uni.deleteStudent("Student0");

        System.out.println("All students at Course1:");
        uni.readAllStudentsByCourse("Course1").forEach(System.out::println);

/*        System.out.println("+++++++++++++++++++");
        System.out.println(uni.readAllCoursesByStudent("Student0"));
        System.out.println("+++++++++++++++++++");
        System.out.println(uni.readAllStudentsByCourse("Course0"));

        System.out.println("Deleting Student0");
        uni.deleteStudent("Student0");
        System.out.println(uni.readAllStudentsByCourse("Course0"));
        System.out.println("Deleting Student1");
        uni.deleteStudent("Student1");
        System.out.println(uni.readAllStudentsByCourse("Course0"));*/

    }

    private static UniversityController getExampleController() {
        UniversityController result = new UniversityController();
        result.createStudent(new Student().setFirstName("Vasya").setLastName("Ivanov").setAddress("Kharkiv"));
        result.createStudent(new Student().setFirstName("Petya").setLastName("Vasilyev").setAddress("Kiyv"));
        result.createStudent(new Student().setFirstName("Igor").setLastName("Petechkin").setAddress("Voronej"));

        result.createCourse(new Course().setName("Mathematics").setDescription("Huge waste of time"));
        result.createCourse(new Course().setName("Game theory").setDescription("Completely useless"));

        result.createStudentInCourse(new StudentInCourse().setCourseId("Course0").setStudentId("Student0"));
        result.createStudentInCourse(new StudentInCourse().setCourseId("Course1").setStudentId("Student0"));
        result.createStudentInCourse(new StudentInCourse().setCourseId("Course0").setStudentId("Student1"));
        result.createStudentInCourse(new StudentInCourse().setCourseId("Course0").setStudentId("Student2"));

        return result;
    }
}
