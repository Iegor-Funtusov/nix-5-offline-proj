package com.nixsolutions.courses;

import com.nixsolutions.courses.obj.Course;
import com.nixsolutions.courses.obj.Student;
import com.nixsolutions.courses.services.CourseService;
import com.nixsolutions.courses.services.StudentService;
import org.junit.jupiter.api.*;

import javax.management.InstanceAlreadyExistsException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentServiceTest {

    private final static StudentService studentService = new StudentService();
    private final static Course COURSE = new Course(5);
    private static String testId;

    @BeforeAll
    public static void init() {
        try {
            CourseService service = new CourseService();
            COURSE.setName("TEST");
            service.create(COURSE);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void create() {
        Student student = new Student();
        student.setName("test");
        student.setAge(21);
        studentService.create(student, COURSE);
        testId = student.getId();

        Assertions.assertNotNull(studentService.read(testId, COURSE));
    }

    @Test
    @Order(2)
    public void readAll() {
        Student[] students = studentService.readAll(COURSE);

        Assertions.assertTrue(students.length != 0);
    }

    @Test
    @Order(3)
    public void update() {
        Student newStudent = studentService.read(testId, COURSE);
        newStudent.setName("UPDATE");

        Assertions.assertNotEquals(studentService.read(testId, COURSE).getName(), "test");
    }

    @Test
    @Order(4)
    public void delete() {
        studentService.delete(testId, COURSE);

        Assertions.assertThrows(RuntimeException.class, () ->{
            studentService.read(testId, COURSE);
        });
    }
}
