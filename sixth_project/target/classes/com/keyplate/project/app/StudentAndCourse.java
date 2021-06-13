package com.keyplate.project.app;

import com.keyplate.project.lib.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class StudentAndCourse extends BaseEntity {
    long studId;
    long courseId;

    public StudentAndCourse(long studId, long courseId) {
        this.studId = studId;
        this.courseId = courseId;
    }

    public StudentAndCourse() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAndCourse that = (StudentAndCourse) o;
        return studId == that.studId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studId, courseId);
    }
}
