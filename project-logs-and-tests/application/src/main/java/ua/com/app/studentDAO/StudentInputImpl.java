package ua.com.app.studentDAO;

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

    static {
        studentService = new StudentService();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void create() throws IOException {
        temporaryStudent = new Student();
        temporaryStudent.setFirstName(inputFirstName());
        temporaryStudent.setLastName(inputLastName());
        studentService.createStudent(temporaryStudent);
        System.out.println(MESSAGE_SUCCESS);
    }

    public void read() throws IOException {
        temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryStudent == null) {
            System.out.println(MESSAGE_EXIST);
        } else {
            System.out.println(temporaryStudent);
        }
    }

    public void update() throws IOException {
        temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryStudent == null) {
            System.out.println(MESSAGE_EXIST);
        } else {
            temporaryStudent.setFirstName(inputFirstName());
            temporaryStudent.setLastName(inputLastName());
            studentService.updateStudent(temporaryStudent);
            System.out.println(MESSAGE_SUCCESS);
        }
    }

    public void delete() throws IOException {
        String id = inputId(MESSAGE_INPUT_STUDENT);
        if (studentService.readStudent(id) == null) {
            System.out.println(MESSAGE_EXIST);
        } else {
            studentService.deleteStudent(id);
            System.out.println(MESSAGE_SUCCESS);
        }
    }

    public static void readAll() {
        String output = studentService.readAllStudents().toString();
        if (output.equals("[]")) {
            System.out.println(MESSAGE_LIST_IS_EMPTY);
        } else {
            System.out.println(output);
        }
    }

    public void addCourse() throws IOException {
        temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryStudent == null) {
            System.out.println(MESSAGE_EXIST);
        } else {
            Course temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_COURSE));
            if (temporaryCourse == null) {
                System.out.println(MESSAGE_COURSE);
            } else {
                temporaryStudent.addCourse(temporaryCourse);
                studentService.updateStudent(temporaryStudent);
                temporaryCourse.addStudent(temporaryStudent);
                courseService.updateCourse(temporaryCourse);
                System.out.println(MESSAGE_SUCCESS);
            }
        }
    }

    public void deleteCourse() throws IOException{
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
