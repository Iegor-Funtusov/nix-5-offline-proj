package ua.com.app.studentDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.app.courseDAO.Course;
import ua.com.app.courseDAO.CourseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentInputImpl {
    public static final StudentService studentService;
    public static final BufferedReader bufferedReader;
    private final CourseService courseService = new CourseService();
    private Student temporaryStudent;
    private static final String REGEX_WORDS = "^[A-z]+$";
    private static final String MESSAGE_EXIST = "Student doesn't exist";
    private static final String MESSAGE_SUCCESS = "Success";
    private static final String MESSAGE_LIST_IS_EMPTY = "Students don't exist";
    private static final String MESSAGE_COURSE = "Course doesn't exist";
    private static final String MESSAGE_INPUT_STUDENT = "Please write a student id:";
    private static final String MESSAGE_INPUT_COURSE = "Please write a course id:";
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    static {
        studentService = new StudentService();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void create() throws IOException {
        temporaryStudent = new Student();
        temporaryStudent.setFirstName(inputFirstName());
        temporaryStudent.setLastName(inputLastName());
        LOGGER_INFO.info("Start create student " + temporaryStudent.getFirstName());
        studentService.createStudent(temporaryStudent);
        LOGGER_INFO.info("End create student");
        System.out.println(MESSAGE_SUCCESS);
    }

    public void read() throws IOException {
        LOGGER_INFO.info("Start read student");
        temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryStudent == null) {
            LOGGER_WARN.warn("Student is null");
            System.out.println(MESSAGE_EXIST);
        } else {
            System.out.println(temporaryStudent);
        }
        LOGGER_INFO.info("End read student");
    }

    public void update() throws IOException {
        LOGGER_INFO.info("Start update student");
        temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryStudent == null) {
            LOGGER_WARN.warn("Student is null");
            System.out.println(MESSAGE_EXIST);
        } else {
            temporaryStudent.setFirstName(inputFirstName());
            temporaryStudent.setLastName(inputLastName());
            studentService.updateStudent(temporaryStudent);
            System.out.println(MESSAGE_SUCCESS);
        }
        LOGGER_INFO.info("End update student");
    }

    public void delete() throws IOException {
        LOGGER_INFO.info("Start delete student");
        String id = inputId(MESSAGE_INPUT_STUDENT);
        if (studentService.readStudent(id) == null) {
            LOGGER_WARN.warn("Student is null");
            System.out.println(MESSAGE_EXIST);
        } else {
            studentService.deleteStudent(id);
            System.out.println(MESSAGE_SUCCESS);
        }
        LOGGER_INFO.info("End delete student");
    }

    public static void readAll() {
        LOGGER_INFO.info("Start read all students");
        String output = studentService.readAllStudents().toString();
        if (output.equals("[]")) {
            LOGGER_WARN.warn("Students don't exists");
            System.out.println(MESSAGE_LIST_IS_EMPTY);
        } else {
            System.out.println(output);
        }
        LOGGER_INFO.info("End read all students");
    }

    public void addCourse() throws IOException {
        LOGGER_INFO.info("Start add course for student");
        temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryStudent == null) {
            LOGGER_WARN.warn("Student is null");
            System.out.println(MESSAGE_EXIST);
        } else {
            Course temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_COURSE));
            if (temporaryCourse == null) {
                LOGGER_WARN.warn("Course is null");
                System.out.println(MESSAGE_COURSE);
            } else {
                temporaryStudent.addCourse(temporaryCourse);
                studentService.updateStudent(temporaryStudent);
                temporaryCourse.addStudent(temporaryStudent);
                courseService.updateCourse(temporaryCourse);
                System.out.println(MESSAGE_SUCCESS);
            }
        }
        LOGGER_INFO.info("End add course for student");
    }

    public void deleteCourse() throws IOException {
        LOGGER_INFO.info("Start delete course for student");
        temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryStudent == null) {
            System.out.println(MESSAGE_EXIST);
        } else {
            Course temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_COURSE));
            if (temporaryCourse == null) {
                System.out.println(MESSAGE_COURSE);
            } else {
                temporaryStudent.deleteCourse(temporaryCourse);
                studentService.updateStudent(temporaryStudent);
                temporaryCourse.deleteStudent(temporaryStudent);
                courseService.updateCourse(temporaryCourse);
                System.out.println(MESSAGE_SUCCESS);
            }
        }
        LOGGER_INFO.info("End delete course for student");
    }

    private String inputFirstName() throws IOException {
        String firstName;
        do {
            System.out.println("Please write a student first name:");
            firstName = bufferedReader.readLine();
        } while (!firstName.matches(REGEX_WORDS));
        return firstName;
    }

    private String inputLastName() throws IOException {
        String lastName;
        do {
            System.out.println("Please write a student last name:");
            lastName = bufferedReader.readLine();
        } while (!lastName.matches(REGEX_WORDS));
        return lastName;
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
