package ua.com.app.courseDAO;

import org.junit.jupiter.api.*;
import ua.com.lib.ArrayImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseServiceTest {

    private static final CourseService courseService = new CourseService();
    private static Course temporaryCourse;
    private static ArrayImpl array;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setTitle(String.valueOf(i));
            course.setDuration(i * 2);
            courseService.createCourse(course);
        }
        array = courseService.readAllCourses();
        temporaryCourse = (Course) array.get(9);
    }

    @Test
    @Order(1)
    public void createStudent() {
        Course course = new Course();
        course.setTitle("Test");
        course.setDuration(50);
        assertEquals(10, courseService.readAllCourses().size());
        assertEquals("Test", course.getTitle());
    }

    @Test
    @Order(2)
    public void shouldThrowAnExceptionIfStudentIsNull() {
        assertThrows(NullPointerException.class, () -> courseService.createCourse(null));
    }

    @Test
    @Order(3)
    public void getSize() {
        assertEquals(10, courseService.readAllCourses().size());
    }

    @Test
    @Order(4)
    public void readStudent() {
        temporaryCourse = (Course) array.get(5);
        assertNotEquals(null, courseService.readCourse(temporaryCourse.getId()));
    }

    @Test
    @Order(5)
    public void deleteStudent() {
        courseService.deleteCourse(temporaryCourse.getId());
        assertEquals(9, courseService.readAllCourses().size());
    }

    @Test
    @Order(6)
    public void updateStudent() {
        ArrayImpl array = courseService.readAllCourses();
        Course course = (Course) array.get(5);
        course.setTitle("Test");
        courseService.updateCourse(course);
        course = (Course) array.get(5);
        assertEquals("Test", course.getTitle());
    }

    @Test
    @Order(7)
    public void isNullIfNullGetById() {
        assertNull(courseService.readCourse(null));
    }
}
