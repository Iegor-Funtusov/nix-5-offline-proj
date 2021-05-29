package org.example.entity;

import java.util.Objects;

public class StudentInCourse extends BaseEntity {
    private String studentId;
    private String courseId;

    public String getStudentId() {
        return studentId;
    }

    public StudentInCourse setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public StudentInCourse setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentInCourse that = (StudentInCourse) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "StudentInCourse{" +
                "id='" + getId() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
