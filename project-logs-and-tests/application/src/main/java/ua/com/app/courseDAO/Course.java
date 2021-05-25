package ua.com.app.courseDAO;

import ua.com.app.studentDAO.Student;
import ua.com.lib.ArrayImpl;
import ua.com.lib.Entity;

public class Course extends Entity {
    private String title;
    private int duration;
    private final ArrayImpl arrayStudents = new ArrayImpl();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void addStudent(Student student) {
        if (!isStudent(student)) {
            arrayStudents.add(student);
        } else {
            System.out.println("Student already exist");
        }
    }

    public void deleteStudent(Student student) {
        if (isStudent(student)) {
            arrayStudents.remove(arrayStudents.indexOf(student));
        } else {
            System.out.println("Student doesn't exist");
        }
    }

    private boolean isStudent(Student student) {
        return arrayStudents.indexOf(student) != -1;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", Students='" + readAllCourseStudents() + '\'' +
                '}';
    }

    private String readAllCourseStudents() {
        StringBuilder sb = new StringBuilder();
        Student student = null;
        for (int i = 0; i < arrayStudents.size(); i++) {
            student = (Student) arrayStudents.get(i);
            sb.append(student.getLastName()).append(", ");
        }
        if (student != null) {
            return sb.substring(0, sb.length() - 2);
        } else {
            return "-";
        }
    }
}
