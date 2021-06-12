package com.nixsolutions.courses.services;

import com.nixsolutions.courses.obj.Course;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.InstanceAlreadyExistsException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class CourseService {

    public final static int SPACE = 28;
    private final static Course[] d = new Course[SPACE];
    private static final Logger loggerInfo = LoggerFactory.getLogger("Information");
    private static final Logger loggerWarn = LoggerFactory.getLogger("Warning");
    private static final Logger loggerError = LoggerFactory.getLogger("Error");

    public boolean create(Course course) throws InstanceAlreadyExistsException {
        loggerInfo.info("Getting the course started: " + course.getName());
        boolean isCreated = false;
        int i = 0;
        while (i < d.length) {
            if (d[i] == null) {
                d[i] = course;
                isCreated = true;
                break;
            } else if (d[i].getName().equals(course.getName())) {
                loggerError.error("The course already exists: " + course.getName());
                throw new InstanceAlreadyExistsException();
            }
            i++;
        }
        if (isCreated) {
            loggerInfo.info("Course creating complete");
        } else {
            loggerError.error("Not enough space");
        }
        return isCreated;
    }

    public Course read(String name) {
        try {
            if (StringUtils.isNotBlank(name)) {
                return getByName(name);
            } else {
                loggerError.error("Course does not exist");
                throw new RuntimeException("Course does not exist");
            }
        } catch (NullPointerException  e) {
            loggerError.error("Course does not exist");
            throw new RuntimeException("Course does not exist");
        }
    }

    public void update(Course course, String name) {
        loggerInfo.info("Started updating course: " + course.getName());
        Course current = read(course.getName());
        if (name.equals(course.getName())) {
        } else {
            try {
                getByName(name);
                loggerError.error("Course with this name already exists");
                throw new RuntimeException("Course with this name already exists");
            } catch (NullPointerException e) {
                course.setName(name);
            }
        }
        try {
            BeanUtils.copyProperties(current, course);
        } catch (IllegalAccessException | InvocationTargetException illegalAccessException) {
            loggerError.error("Student update error ");
            illegalAccessException.printStackTrace();
        }
        loggerInfo.info("Course update completed");
    }

    public void delete(String name) {
        loggerWarn.warn("Start deleting a course by name: " + name);
        Course current = read(name);
        IntStream.range(0, d.length)
                .filter(i -> d[i].getName().equals(current.getName()))
                .findFirst()
                .ifPresent(i -> d[i] = null);
        loggerWarn.warn("Course deletion completed");
    }

    public Course[] readAll() {
        return Arrays.stream(d)
                .filter(Objects::nonNull)
                .toArray(Course[]::new);
    }

    private Course getByName(String name) throws NullPointerException {
        return Arrays.stream(d)
                .filter(g -> g.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}