package ua.com.app.courseDAO;

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

    static {
        courseService = new CourseService();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void create() throws IOException {
        temporaryCourse = new Course();
        temporaryCourse.setTitle(inputTitle());
        temporaryCourse.setDuration(inputDuration());
        courseService.createCourse(temporaryCourse);
        System.out.println(MESSAGE_SUCCESS);
    }

    public void read() throws IOException {
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_COURSE));
        if (temporaryCourse == null) {
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            System.out.println(temporaryCourse);
        }
    }

    public void update() throws IOException {
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_COURSE));
        if (temporaryCourse == null) {
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            temporaryCourse.setTitle(inputTitle());
            temporaryCourse.setDuration(inputDuration());
            courseService.updateCourse(temporaryCourse);
            System.out.println(MESSAGE_SUCCESS);
        }
    }

    public void delete() throws IOException {
        String id = inputId(MESSAGE_INPUT_COURSE);
        if (courseService.readCourse(id) == null) {
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            courseService.deleteCourse(id);
            System.out.println(MESSAGE_SUCCESS);
        }
    }

    public static void readAll() {
        String output = courseService.readAllCourses().toString();
        if (output.equals("[]")) {
            System.out.println(MESSAGE_LIST_IS_EMPTY);
        } else {
            System.out.println(output);
        }
    }

    public void addStudent() throws IOException {
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryCourse == null) {
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            Student temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
            if (temporaryStudent == null) {
                System.out.println(MESSAGE_STUDENT);
            } else {
                temporaryCourse.addStudent(temporaryStudent);
                courseService.updateCourse(temporaryCourse);
                temporaryStudent.addCourse(temporaryCourse);
                studentService.updateStudent(temporaryStudent);
                System.out.println(MESSAGE_SUCCESS);
            }
        }
    }

    public void deleteStudent() throws IOException {
        temporaryCourse = courseService.readCourse(inputId(MESSAGE_INPUT_STUDENT));
        if (temporaryCourse == null) {
            System.out.println(MESSAGE_DOESNT_EXIST);
        } else {
            Student temporaryStudent = studentService.readStudent(inputId(MESSAGE_INPUT_STUDENT));
            if (temporaryStudent == null) {
                System.out.println(MESSAGE_STUDENT);
            } else {
                temporaryCourse.deleteStudent(temporaryStudent);
                courseService.updateCourse(temporaryCourse);
                temporaryStudent.deleteCourse(temporaryCourse);
                studentService.updateStudent(temporaryStudent);
                System.out.println(MESSAGE_SUCCESS);
            }
        }
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
