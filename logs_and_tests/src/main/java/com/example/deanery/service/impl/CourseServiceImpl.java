package com.example.deanery.service.impl;

import com.example.deanery.dao.CourseDao;
import com.example.deanery.dao.impl.CourseDaoImpl;
import com.example.deanery.model.Course;
import com.example.deanery.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseServiceImpl implements CourseService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void create(Course course) {
        if (!isCourseExistByName(course)) {
            LOGGER_INFO.info("Start create course: " + course.getName());
            courseDao.create(course);
            LOGGER_INFO.info("End create student: " + course.getName());
        }
    }

    @Override
    public void update(Course course) {
        if (!isCourseExistByName(course) && courseIsExist(course.getId())) {
            LOGGER_WARN.warn("Start update course: " + course.getId());
            courseDao.update(course);
            LOGGER_WARN.warn("End update course: " + course.getId());
        }
    }

    @Override
    public void delete(String id) {
        if(courseIsExist(id)){
            LOGGER_WARN.warn(("Start delete course ID:" + id));
            courseDao.delete(id);
            LOGGER_WARN.warn(("End delete course ID:" + id));
        }
    }

    @Override
    public Course findById(String id) {
        return courseDao.findById(id);
    }

    @Override
    public Course findByName(String name){
        return courseDao.findByName(name);
    }

    @Override
    public Course[] findAll() {
        return courseDao.findAll();
    }

    private boolean isCourseExistByName(Course course) {
        if (course != null && course.getName() != null) {
            Course course1 = findByName(course.getName());
            if (course1 == null) {
                return false;
            } else {
                LOGGER_ERROR.error("this course is exist: " + course.getName());
            }
        } else {
            LOGGER_ERROR.error("course name can't be empty");
        }
        return true;
    }

    private boolean courseIsExist(String id){
        return courseDao.findById(id) != null;
    }
}
