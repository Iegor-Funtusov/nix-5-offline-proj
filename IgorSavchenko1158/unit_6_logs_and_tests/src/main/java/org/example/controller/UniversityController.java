package org.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.CourseDao;
import org.example.dao.StudentDao;
import org.example.entity.StudentInCourse;
import org.example.dao.StudentInCourseDao;
import org.example.entity.Course;
import org.example.entity.Student;

import java.util.Collection;
import java.util.stream.Collectors;

public class UniversityController {
    private static final Logger logger = LogManager.getLogger(UniversityController.class);

    private final CourseDao courseDao = new CourseDao();
    private final StudentDao studentDao = new StudentDao();
    private final StudentInCourseDao stCsDao = new StudentInCourseDao();

    public UniversityController() {
        logger.debug(this);
    }

    public String createStudent(Student student) {
        logger.debug("Start createStudent " + student);
        if (!validateStudent(student)) {
            logger.error("Failed validate student");
            throw new IllegalArgumentException("Not valid student");
        }
        logger.debug("End createStudent");
        return studentDao.create(student);
    }

    public String createCourse(Course course) {
        logger.debug("Start createCourse " + course);
        if (!validateCourse(course)) {
            logger.error("createCourse failed as Not valid course");
            throw new IllegalArgumentException("Not valid course");
        }
        return courseDao.create(course);
    }

    public String createStudentInCourse(StudentInCourse stCs) {
        logger.debug("Start createStudentInCourse " + stCs);
        if (stCs == null) {
            logger.error("createStudentInCourse failed as Not valid argument");
            throw new IllegalArgumentException("Not valid argument");
        }

        Student student = studentDao.read(stCs.getStudentId());
        Course course = courseDao.read(stCs.getCourseId());

        if (student == null || course == null) {
            logger.error("createStudentInCourse failed as Student or Course does not exist");

            throw new IllegalArgumentException("Student or Course does not exist");
        }

        if (stCsDao.read()
                .stream()
                .anyMatch(e -> e.getStudentId().equals(stCs.getStudentId()) && e.getCourseId().equals(stCs.getCourseId()))) {
            logger.error("createStudentInCourse failed as Student already attends Course");
            throw new IllegalArgumentException("Student already attends Course");
        }

        logger.debug("End createStudentInCourse");
        return stCsDao.create(stCs);
    }

    public Student readStudent(String id) {
        logger.debug("Start readStudent " + id);
        return studentDao.read(id);
    }

    public Course readCourse(String id) {
        logger.debug("start readCourse " + id);
        return courseDao.read(id);
    }

    public Collection<Student> readStudent() {
        logger.debug("Start readStudent");
        return studentDao.read();
    }

    public Collection<Course> readCourse() {
        logger.debug("start readCourse");
        return courseDao.read();
    }

    public Collection<Course> readAllCoursesByStudent(String studentId) {
        logger.debug("Start readAllCoursesByStudent " + studentId);
        if (studentDao.read().stream().noneMatch(e -> e.getId().equals(studentId))) {
            logger.error("readAllCoursesByStudent failed as No student with such id");
            throw new IllegalArgumentException("No student with such id");
        }
        logger.debug("End readAllCoursesByStudent");
        return stCsDao.read()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .map(e -> courseDao.read(e.getCourseId()))
                .collect(Collectors.toList());
    }

    public Collection<Student> readAllStudentsByCourse(String courseId) {
        logger.debug("Start readAllStudentsByCourse " + courseId);
        if (courseDao.read().stream().noneMatch(e -> e.getId().equals(courseId))) {
            logger.error("readAllStudentsByCourse failed as No course with such id");
            throw new IllegalArgumentException("No course with such id");
        }
        logger.debug("End readAllStudentsByCourse");
        return stCsDao.read()
                .stream()
                .filter(e -> e.getCourseId().equals(courseId))
                .map(e -> studentDao.read(e.getStudentId()))
                .collect(Collectors.toList());
    }

    public void updateStudent(Student student) {
        logger.debug("Start updateStudent " + student);
        if (student == null || studentDao.read().stream().noneMatch(e -> e.getId().equals(student.getId()))) {
            logger.error("updateStudent failed as No such student to update");
            throw new IllegalArgumentException("No such student to update");
        }
        if (!validateStudent(student)) {
            logger.error("updateStudent failed as Not valid student");
            throw new IllegalArgumentException("Not valid student");
        }
        logger.debug("End updateStudent");
        studentDao.update(student);
    }

    public void updateCourse(Course course) {
        logger.debug("Start updateCourse " + course);
        if (course == null || courseDao.read().stream().noneMatch(e -> e.getId().equals(course.getId()))) {
            logger.error("updateStudent failed as No such course to update");
            throw new IllegalArgumentException("No such course to update");
        }
        if (!validateCourse(course)) {
            logger.error("updateCourse failed as Not valid course");
            throw new IllegalArgumentException("Not valid course");
        }
        logger.debug("End updateCourse");
        courseDao.update(course);
    }

    public void deleteStudent(String id) {
        logger.debug("Start deleteStudent " + id);
        studentDao.delete(id);
        stCsDao.read()
                .stream()
                .filter(e -> e.getStudentId().equals(id))
                .map(e -> e.getId())
                .forEach(stCsDao::delete);
        logger.debug("End deleteStudent");
    }

    public void deleteCourse(String id) {
        logger.debug("Start deleteCourse " + id);
        courseDao.delete(id);
        stCsDao.read()
                .stream()
                .filter(e -> e.getCourseId().equals(id))
                .map(e -> e.getId())
                .forEach(stCsDao::delete);
        logger.debug("End deleteCourse");
    }

    public void deleteStudentInCourse(String studentId, String courseId) {
        logger.debug("deleteStudentInCourse " + studentId + "; " + courseId);
        stCsDao.delete(
                stCsDao.read()
                        .stream()
                        .filter(e -> e.getStudentId().equals(studentId)
                                && e.getCourseId().equals(courseId))
                        .findFirst()
                        .orElse(new StudentInCourse()).getId());
        logger.debug("End deleteStudentInCourse");
    }

    private boolean validateStudent(Student student) {
        logger.debug("Start validateStudent " + student);
        if (student == null || student.getFirstName() == null || student.getLastName() == null) {
            logger.error("Fail validateStudent");
            return false;
        }
        student.setFirstName(student.getFirstName().strip());
        student.setLastName(student.getLastName().strip());
        logger.debug("End validateStudent");
        return validStudentName(student.getFirstName()) && validStudentName(student.getLastName());
    }

    private boolean validStudentName(String name) {
        logger.debug("Start validStudentName " + name);
        return !name.isEmpty() && name.matches("[a-zA-Z ,.'-]+");
    }

    private boolean validateCourse(Course course) {
        logger.debug("Start validateCourse");
        return course != null && !course.getName().isEmpty() && !course.getName().isBlank();
    }
}
