package com.example.deanery.model;

public class CourseRegister {
    private String id;
    private Course course;
    private Student student;
    private boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "CourseRegister{" +
                "id='" + id + '\'' +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
