package ua.com.app.courseDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.app.studentDAO.Student;
import ua.com.app.studentDAO.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CourseInputImpl {
    public static final CourseService courseService;
    public static final BufferedReader bufferedReader;
    private final StudentService studentService = new StudentService();
    private static Course temporaryCourse;
    private static final String REGEX_WORDS = "^[A-z\\s0-9]+$";
    private static final String REGEX_DIGITS = "^[0-9]+$";
    private static final String MESSAGE_SUCCESS = "Success";
    private static final String MESSAGE_INPUT_COURSE = "Please write a course id:";
    private static final String MESSAGE_INPUT_STUDENT = "Please write a student id:";
    private static final String MESSAGE_DOESNT_EXIST = "Course doesn't exist";
    private static final String MESSAGE_LIST_IS_EMPTY = "Courses don't exist";
    private static final String MESSAGE_STUDENT = "Student doesn't exist";
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    static {
        courseService = new CourseService();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void create() throws IOException {
        LOGGER_INFO.info("Start create course");
        temporaryCourse = new Course();
        temporaryCourse.setTitle(inputTitle());
        temporaryCourse.setDuration(inputDuration());
        courseService.createCourse(temporaryCourse);
        System.out.println(MESSAGE_SUCCESS);
        LOGGER_INFO.info("End create course");
    }

    public void read() throws IOException {
        LOGGER_INFO.info("Start read course");
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_COURSE));
        if (temporaryCourse == null) {
            LOGGER_WARN.warn("Course is null");
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            System.out.println(temporaryCourse);
        }
        LOGGER_INFO.info("End read course");
    }

    public void update() throws IOException {
        LOGGER_INFO.info("Start update course");
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_COURSE));
        if (temporaryCourse == null) {
            LOGGER_WARN.warn("Course is null");
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            temporaryCourse.setTitle(inputTitle());
            temporaryCourse.setDuration(inputDuration());
            courseService.updateCourse(temporaryCourse);
            System.out.println(MESSAGE_SUCCESS);
        }
        LOGGER_INFO.info("End update course");
    }

    public void delete() throws IOException {
        LOGGER_INFO.info("Start delete course");
        String id = inputId(MESSAGE_INPUT_COURSE);
        if (courseService.readCourse(id) == null) {
            LOGGER_WARN.warn("Course is null");
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            courseService.deleteCourse(id);
            System.out.println(MESSAGE_SUCCESS);
        }
        LOGGER_INFO.info("End delete course");
    }

    public static void readAll() {
        LOGGER_INFO.info("Start read all course");
        String output = courseService.readAllCourses().toString();
        if (output.equals("[]")) {
            LOGGER_WARN.warn("Courses don't exists");
            System.out.println(MESSAGE_LIST_IS_EMPTY);
        } else {
            System.out.println(output);
        }
        LOGGER_INFO.info("End read all course");
    }

    public void addStudent() throws IOException {
        LOGGER_INFO.info("Start add student for course");
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryCourse == null) {
            LOGGER_WARN.warn("Course is null");
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            Student temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
            if (temporaryStudent == null) {
                LOGGER_WARN.warn("Student is null");
                System.out.println(MESSAGE_STUDENT);
            } else {
                temporaryCourse.addStudent(temporaryStudent);
                courseService.updateCourse(temporaryCourse);
                temporaryStudent.addCourse(temporaryCourse);
                studentService.updateStudent(temporaryStudent);
                System.out.println(MESSAGE_SUCCESS);
            }
        }
        LOGGER_INFO.info("End add student for course");
    }

    public void deleteStudent() throws IOException {
        LOGGER_INFO.info("Start delete student for course");
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryCourse == null) {
            LOGGER_WARN.warn("Course is null");
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            Student temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
            if (temporaryStudent == null) {
                LOGGER_WARN.warn("Student is null");
                System.out.println(MESSAGE_STUDENT);
            } else {
                temporaryCourse.deleteStudent(temporaryStudent);
                courseService.updateCourse(temporaryCourse);
                temporaryStudent.deleteCourse(temporaryCourse);
                studentService.updateStudent(temporaryStudent);
                System.out.println(MESSAGE_SUCCESS);
            }
        }
        LOGGER_INFO.info("End add student for course");
    }

    private String inputTitle() throws IOException {
        String title;
        do {
            System.out.println("Please write a title of course (max length is 75 symbols):");
            title = bufferedReader.readLine();
        } while (!title.matches(REGEX_WORDS) || title.isBlank() || title.length() > 75);
        return title;
    }

    private int inputDuration() throws IOException {
        String duration;
        do {
            System.out.println("Please write a duration of course in hours:");
            duration = bufferedReader.readLine();
        } while (!duration.matches(REGEX_DIGITS));
        return Integer.parseInt(duration);
    }

    private String inputId(String message) throws IOException {
        String id;
        do {
            System.out.println(message);
            id = bufferedReader.readLine();
        } while (id.isBlank() || id.isEmpty());
        return id;
    }
}
