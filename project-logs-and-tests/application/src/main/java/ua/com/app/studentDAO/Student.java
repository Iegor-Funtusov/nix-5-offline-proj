package ua.com.app.studentDAO;

import ua.com.app.courseDAO.Course;
import ua.com.lib.ArrayImpl;
import ua.com.lib.Entity;

public class Student extends Entity {
    private String firstName;
    private String lastName;
    private final ArrayImpl arrayCourses = new ArrayImpl();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void addCourse(Course course) {
        if (!isCourse(course)) {
            arrayCourses.add(course);
        } else {
            System.out.println("Course already exist");
        }
    }

    public void deleteCourse(Course course) {
        if (isCourse(course)) {
            arrayCourses.remove(arrayCourses.indexOf(course));
        } else {
            System.out.println("Course doesn't exist");
        }
    }

    private boolean isCourse(Course course) {
        return arrayCourses.indexOf(course) != -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Courses='" + readAllStudentCourses() + '\'' +
                '}';
    }

    private String readAllStudentCourses() {
        StringBuilder sb = new StringBuilder();
        Course course = null;
        for (int i = 0; i < arrayCourses.size(); i++) {
            course = (Course) arrayCourses.get(i);
            sb.append(course.getTitle()).append(", ");
        }
        if (course != null) {
            return sb.substring(0, sb.length() - 2);
        } else {
            return "-";
        }
    }

}
