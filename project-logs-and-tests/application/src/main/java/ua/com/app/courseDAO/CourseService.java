package ua.com.app.courseDAO;

import ua.com.lib.ArrayCrudService;
import ua.com.lib.ArrayImpl;

public class CourseService {
    private static final ArrayCrudService<Course> courseCrudService = new ArrayCrudService<>();

    public void createCourse(Course course) {
        courseCrudService.create(course);
    }

    public Course readCourse(String id) {
        return courseCrudService.read(id);
    }

    public void updateCourse(Course course) {
        courseCrudService.update(course);
    }

    public void deleteCourse(String id) {
        courseCrudService.delete(id);
    }

    public ArrayImpl readAllCourses() {
        return courseCrudService.readAll();
    }
}
