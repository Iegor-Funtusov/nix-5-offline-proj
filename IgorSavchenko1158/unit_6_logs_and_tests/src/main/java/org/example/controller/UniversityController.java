package org.example.controller;

import org.example.dao.CourseDao;
import org.example.dao.StudentDao;
import org.example.entity.StudentInCourse;
import org.example.dao.StudentInCourseDao;
import org.example.entity.Course;
import org.example.entity.Student;

import java.util.Collection;
import java.util.stream.Collectors;

public class UniversityController {
    private final CourseDao courseDao = new CourseDao();
    private final StudentDao studentDao = new StudentDao();
    private final StudentInCourseDao stCsDao = new StudentInCourseDao();

    public String createStudent(Student student) {
        if (!validateStudent(student)) {
            throw new IllegalArgumentException("Not valid student");
        }
        return studentDao.create(student);
    }

    public String createCourse(Course course) {
        if (!validateCourse(course)) {
            throw new IllegalArgumentException("Not valid course");
        }
        return courseDao.create(course);
    }

    public String createStudentInCourse(StudentInCourse stCs) {
        if (stCs == null) {
            throw new IllegalArgumentException("Not valid argument");
        }

        Student student = studentDao.read(stCs.getStudentId());
        Course course = courseDao.read(stCs.getCourseId());

        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course does not exist");
        }

        if (stCsDao.read()
                .stream()
                .anyMatch(e -> e.getStudentId().equals(stCs.getStudentId()) && e.getCourseId().equals(stCs.getCourseId()))) {
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

    public Collection<Course> readAllCoursesByStudent(String studentId) {
        if (studentDao.read().stream().noneMatch(e -> e.getId().equals(studentId))) {
            throw new IllegalArgumentException("No student with such id");
        }
        return stCsDao.read()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .map(e -> courseDao.read(e.getCourseId()))
                .collect(Collectors.toList());
    }

    public Collection<Student> readAllStudentsByCourse(String courseId) {
        if (courseDao.read().stream().noneMatch(e -> e.getId().equals(courseId))) {
            throw new IllegalArgumentException("No course with such id");
        }
        return stCsDao.read()
                .stream()
                .filter(e -> e.getCourseId().equals(courseId))
                .map(e -> studentDao.read(e.getStudentId()))
                .collect(Collectors.toList());
    }

    public void updateStudent(Student student) {
        if (student == null || studentDao.read().stream().noneMatch(e -> e.getId().equals(student.getId()))) {
            throw new IllegalArgumentException("No such student to update");
        }
        if (!validateStudent(student)) {
            throw new IllegalArgumentException("Not valid student");
        }
        studentDao.update(student);
    }

    public void updateCourse(Course course) {
        if (!validateCourse(course)) {
            throw new IllegalArgumentException("Not valid course");
        }
        courseDao.update(course);
    }

    public void deleteStudent(String id) {
        studentDao.delete(id);
        stCsDao.read()
                .stream()
                .filter(e -> e.getStudentId().equals(id))
                .map(e -> e.getId())
                .forEach(stCsDao::delete);
    }

    public void deleteCourse(String id) {
        courseDao.delete(id);
        stCsDao.read()
                .stream()
                .filter(e -> e.getCourseId().equals(id))
                .map(e -> e.getId())
                .forEach(stCsDao::delete);
    }

    public void deleteStudentInCourse(String studentId, String courseId) {
        stCsDao.delete(stCsDao.read()
                .stream()
                .filter(e -> e.getStudentId().equals(studentId)
                        && e.getCourseId().equals(courseId))
                .findFirst()
                .orElse(new StudentInCourse()).getId());
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
        return !name.isEmpty() && name.matches("[a-zA-Z ,.'-]+");
    }

    private boolean validateCourse(Course course) {
        return course != null && !course.getName().isEmpty() && !course.getName().isBlank();
    }
}
