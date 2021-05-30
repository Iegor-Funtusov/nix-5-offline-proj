package ua.com.app.studentDAO;

import org.junit.jupiter.api.*;
import ua.com.lib.ArrayImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentServiceTest {

    private static final StudentService studentService = new StudentService();
    private static Student temporaryStudent;
    private static ArrayImpl array;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setFirstName(String.valueOf(i));
            student.setLastName(String.valueOf(i * 2));
            studentService.createStudent(student);
        }
        array = studentService.readAllStudents();
        temporaryStudent = (Student) array.get(9);
    }

    @Test
    @Order(1)
    public void createStudent() {
        Student student = new Student();
        student.setFirstName("Test");
        student.setLastName("Driven");
        assertEquals(10, studentService.readAllStudents().size());
        assertEquals("Driven", student.getLastName());
        assertEquals("Test", student.getFirstName());
    }

    @Test
    @Order(2)
    public void shouldThrowAnExceptionIfStudentIsNull() {
        assertThrows(NullPointerException.class, () -> studentService.createStudent(null));
    }

    @Test
    @Order(3)
    public void getSize() {
        assertEquals(10, studentService.readAllStudents().size());
    }

    @Test
    @Order(4)
    public void readStudent() {
        temporaryStudent = (Student) array.get(5);
        assertNotEquals(null, studentService.readStudent(temporaryStudent.getId()));
    }

    @Test
    @Order(5)
    public void deleteStudent() {
        studentService.deleteStudent(temporaryStudent.getId());
        assertEquals(9, studentService.readAllStudents().size());
    }

    @Test
    @Order(6)
    public void updateStudent() {
        ArrayImpl array = studentService.readAllStudents();
        Student student = (Student) array.get(5);
        student.setLastName("Test");
        student.setFirstName("Test");
        studentService.updateStudent(student);
        student = (Student) array.get(5);
        assertEquals("Test", student.getLastName());
    }

    @Test
    @Order(7)
    public void isNullIfNullGetById() {
        assertNull(studentService.readStudent(null));
    }

}
