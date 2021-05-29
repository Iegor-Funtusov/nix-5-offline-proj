package org.example.controller;

import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.example.entity.Student;
import org.example.entity.StudentInCourse;
import org.junit.jupiter.api.*;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UniversityControllerTest {

    static UniversityController uni;

    @BeforeEach
    void setUp() {
        uni = new UniversityController();
    }

    @Test
    void createStudent() {
        assertEquals(uni.readStudent().size(), 0);
        final Student student = new Student();
        student.setFirstName("Valid");
        student.setLastName("Name");
        assertDoesNotThrow(() -> uni.createStudent(student));
        assertEquals(uni.readStudent().size(), 1);

        student.setFirstName("B4d");
        student.setLastName("NAM3");
        assertThrows(IllegalArgumentException.class, () -> uni.createStudent(student));
        assertEquals(uni.readStudent().size(), 1);
    }

    @Test
    void createCourse() {
        assertEquals(uni.readCourse().size(), 0);
        final Course course = new Course();
        course.setName("Valid");
        course.setDescription("Desc");
        assertDoesNotThrow(() -> uni.createCourse(course));
        assertEquals(uni.readCourse().size(), 1);

        course.setName("");
        course.setDescription("        ");
        assertThrows(IllegalArgumentException.class, () -> uni.createCourse(course));
        assertEquals(uni.readCourse().size(), 1);
    }

    @Test
    void createStudentInCourse() {
        Student student = new Student();
        student.setFirstName("Vova");
        student.setLastName("Dubov");
        String studentId = uni.createStudent(student);
        Course tempCourse = new Course();
        tempCourse.setName("Math");
        tempCourse.setDescription("2+2=4, 4-1=3");
        String courseId = uni.createCourse(tempCourse);

        StudentInCourse studentInCourse1 = new StudentInCourse();
        studentInCourse1.setStudentId(studentId);
        studentInCourse1.setCourseId(courseId);
        assertDoesNotThrow(() -> uni.createStudentInCourse(studentInCourse1));

        StudentInCourse studentInCourse2 =new StudentInCourse();
        studentInCourse2.setStudentId(studentId);
        studentInCourse2.setCourseId(courseId);
        assertThrows(IllegalArgumentException.class,
                () -> uni.createStudentInCourse(studentInCourse2));

        StudentInCourse studentInCourse3 = new StudentInCourse();
        studentInCourse3.setStudentId("fake id");
        studentInCourse3.setCourseId("fake id2");
        assertThrows(IllegalArgumentException.class,
                () -> uni.createStudentInCourse(studentInCourse3));
    }

    @Test
    void readAllCoursesByStudent() {
        Student student = new Student();
        student.setFirstName("Vova");
        student.setLastName("Lastnamich");
        String studentId = uni.createStudent(student);
        Course course = new Course();
        course.setName("Math");
        course.setDescription("2+2 is 4");
        String courseId = uni.createCourse(course);
        StudentInCourse studentInCourse = new StudentInCourse();
        studentInCourse.setStudentId(studentId);
        studentInCourse.setCourseId(courseId);
        uni.createStudentInCourse(studentInCourse);
        Collection<Course> courseCollection = uni.readAllCoursesByStudent(studentId);

        assertEquals(courseCollection.size(), 1);
        assertThrows(IllegalArgumentException.class, () -> uni.readAllCoursesByStudent("fake id"));
        assertEquals(courseCollection.size(), 1);
    }

    @Test
    void readAllStudentsByCourse() {
        Student student = new Student();
        student.setFirstName("Vova");
        student.setLastName("Lastnamich");
        String studentId = uni.createStudent(student);
        Course course = new Course();
        course.setName("Math");
        course.setDescription("2+2 is 4");
        String courseId = uni.createCourse(course);
        StudentInCourse studentInCourse = new StudentInCourse();
        studentInCourse.setStudentId(studentId);
        studentInCourse.setCourseId(courseId);
        uni.createStudentInCourse(studentInCourse);
        Collection<Student> studentCollection = uni.readAllStudentsByCourse(courseId);

        assertEquals(studentCollection.size(), 1);
        assertThrows(IllegalArgumentException.class, () -> uni.readAllStudentsByCourse("Fake id"));
        assertEquals(studentCollection.size(), 1);
    }

    @Test
    void updateStudent() {
        Student student = new Student();
        student.setFirstName("Vova");
        student.setLastName("Lastnamich");
        student.setAddress("Kharkiv");
        String studentId = uni.createStudent(student);


        Student newStudent = new Student();
        newStudent.setFirstName("Biba");
        newStudent.setLastName("Lastnamich Jr.");
        newStudent.setAddress("Kharkiv");
        newStudent.setId(studentId);
        uni.updateStudent(newStudent);
        uni.readStudent().forEach(System.out::println);
        assertEquals(uni.readStudent(studentId).getLastName(), "Lastnamich Jr.");
    }

    @Test
    void updateCourse() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void deleteCourse() {
    }

    @Test
    void deleteStudentInCourse() {
    }
}