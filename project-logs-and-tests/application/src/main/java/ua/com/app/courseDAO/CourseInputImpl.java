package ua.com.app.courseDAO;

import ua.com.lib.ArrayImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CourseInputImpl {
    public static final CourseService courseService;
    public static final BufferedReader bufferedReader;
    private static Course temporaryCourse;
    private static final String REGEX_WORDS = "^[A-z\\s0-9]+$";
    private static final String REGEX_DIGITS = "^[0-9]+$";

    static {
        courseService = new CourseService();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void create() throws IOException {
        temporaryCourse = new Course();
        temporaryCourse.setTitle(inputTitle());
        temporaryCourse.setDuration(inputDuration());
        courseService.createCourse(temporaryCourse);
    }

    public Course read() throws IOException {
        String id = inputId();
        if (id == null) {
            System.out.println("Id doesn't exist");
        }
        return courseService.readCourse(id);
    }

    public void update() throws IOException {
        String id = inputId();
        if (id != null) {
            temporaryCourse = courseService.readCourse(id);
            temporaryCourse.setTitle(inputTitle());
            temporaryCourse.setDuration(inputDuration());
            courseService.updateCourse(temporaryCourse);
        } else {
            System.out.println("Course doesn't exist");
        }
    }

    public void delete() throws IOException {
        String id = inputId();
        if (id != null) {
            courseService.deleteCourse(id);
        } else {
            System.out.println("Id doesn't exist");
        }
    }

    public ArrayImpl readAll() {
        return courseService.readAllCourses();
    }

    private String inputTitle() throws IOException {
        String title;
        do {
            System.out.print("Please write a title of course (max length is 75 symbols): ");
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

    private String inputId() throws IOException {
        System.out.println("Please write a id: ");
        return bufferedReader.readLine();
    }

}
