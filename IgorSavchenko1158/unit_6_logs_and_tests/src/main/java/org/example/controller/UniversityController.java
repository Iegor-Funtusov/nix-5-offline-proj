package org.example.controller;

import org.example.dao.CourseDao;
import org.example.dao.StudentDao;
import org.example.dao.StudentInCourse;
import org.example.dao.StudentInCourseDao;
import org.example.entity.Course;
import org.example.entity.Student;

import java.util.Collection;

public class UniversityController {
    private final CourseDao courseDao = new CourseDao();
    private final StudentDao studentDao = new StudentDao();
    private final StudentInCourseDao stCsDao = new StudentInCourseDao();

    public String create(Student student) {
        if (!validateStudent(student)) {
            throw new IllegalArgumentException("Not valid student");
        }
        return studentDao.create(student);
    }

    public String create(Course course) {
        if (!validateCourse(course)) {
            throw new IllegalArgumentException("Not valid course");
        }
        return courseDao.create(course);
    }

    public String create(StudentInCourse stCs) {
        if (stCs == null) {
            throw new IllegalArgumentException("Not valid argument");
        }

        Student student = studentDao.read(stCs.getStudentId());
        Course course = courseDao.read(stCs.getCourseId());

        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course does not exist");
        }

        long exists = stCsDao.read()
                .stream()
                .filter(e -> e.equals(stCs))
                .count();
        if (exists > 0) {
            throw new IllegalArgumentException("Student already attends Course");
        }
        return stCsDao.create(stCs);
    }

    public Student readStudent(String id) {
        return studentDao.read(id);
    }

    public Course readCourse(String id) {
        return courseDao.read(id);
    }

    public Collection<Student> readStudent() {
        return studentDao.read();
    }

    public Collection<Course> readCourse() {
        return courseDao.read();
    }

    public readAllStudentsAndTheirCourses()

    public void updateStudent() {

    }

    public void updateCourse() {
    }

    public void deleteStudent(String id) {

    }

    public void deleteCourse(String id) {

    }

    public void deleteStudentInCourse(String id) {

    }

    private boolean validateStudent(Student student) {
        if (student == null || student.getFirstName() == null || student.getLastName() == null) {
            return false;
        }

        student.setFirstName(student.getFirstName().strip());
        student.setLastName(student.getLastName().strip());

        return validStudentName(student.getFirstName()) && validStudentName(student.getLastName());
    }

    private boolean validStudentName(String name) {
        return !name.isEmpty() && name.matches("^[a-z ,.'-]+$");
    }

    private boolean validateCourse(Course course) {
        return course != null && !course.getName().isEmpty() && !course.getName().isBlank();
    }
}
