package com.nixsolutions.courses.services;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nixsolutions.courses.obj.Course;
import com.nixsolutions.courses.obj.Student;

import java.util.Objects;
import java.util.UUID;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class StudentService {

    private final CourseService courseService = new CourseService();
    private Student[] list;
    private static final Logger loggerWarn = LoggerFactory.getLogger("Warning");
    private static final Logger loggerError = LoggerFactory.getLogger("Error");
    private static final Logger loggerInfo = LoggerFactory.getLogger("Information");

    public boolean create(Student student, Course course) {
        loggerInfo.info("Started to create a student: " + student.getId());
        list = course.getList();
        student.setCourseName(course.getName());
        student.setId(generateId(UUID.randomUUID().toString()));
        boolean isCreated = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = student;
                isCreated = true;
                break;
            }
        }
        if (isCreated) {
            loggerInfo.info("Updating the course list: " + course.getName());
            course.setList(list);
            courseService.update(course, course.getName());
            loggerInfo.info("Student creation completed");
        } else {
            loggerError.error("Not enough space");
        }
        return isCreated;
    }

    public Student read(String name, Course course) {
        try {
            if (StringUtils.isNotBlank(name)) {
                list = course.getList();
                return getById(name);
            } else {
                loggerError.error("The student does not exist");
                throw new RuntimeException("The student does not exist");
            }
        } catch (NullPointerException e) {
            loggerError.error("The student does not exist");
            throw new RuntimeException("The student does not exist");
        }
    }

    public boolean update(Student student, Course course) {
        loggerInfo.info("Started to update the student: " + student.getId());
        list = course.getList();
        Student current = read(student.getId(), course);
        boolean isUpdated = false;
        try {
            BeanUtils.copyProperties(current, student);
            for (int i = 0; i < list.length; i++) {
                if(list[i].getId().equals(student.getId())) {
                    list[i] = student;
                    isUpdated = true;
                    break;
                }
            }
        } catch (IllegalAccessException | InvocationTargetException illegalAccessException) {
            loggerError.error("Student update error ");
            illegalAccessException.printStackTrace();
        }
        if (isUpdated) {
            loggerInfo.info("Updating the course list: " + course.getName());
            course.setList(list);
            courseService.update(course, course.getName());
            loggerInfo.info("Student update completed");
        } else {
            loggerError.error("Student update error");
        }
        return isUpdated;
    }

    public boolean delete(String id, Course course) {
        loggerWarn.warn("Started deleting students by ID: " + id);
        list = course.getList();
        Student current = read(id, course);
        boolean isDeleted = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getId().equals(current.getId())) {
                list[i] = null;
                isDeleted = true;
                break;
            }
        }
        if (isDeleted) {
            loggerInfo.info("Updating the course: " + course.getName());
            course.setList(list);
            courseService.update(course, course.getName());
            loggerWarn.warn("Completed removal of the student");
        } else {
            loggerError.error("Error when deleting a student");
        }
        return isDeleted;
    }

    public Student[] readAll(Course course) {
        list = course.getList();
        return Arrays.stream(list)
                .filter(Objects::nonNull)
                .toArray(Student[]::new);
    }

    private Student getById(String id) {
        return Arrays.stream(list)
                .filter(i -> i.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    private String generateId(String id) {
        if (Arrays.stream(list)
                .filter(Objects::nonNull)
                .anyMatch(i -> i.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

}
