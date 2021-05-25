package com.example.deanery.service.impl;

import com.example.deanery.dao.CourseRegisterDao;
import com.example.deanery.dao.impl.CourseRegisterDaoImpl;
import com.example.deanery.model.CourseRegister;
import com.example.deanery.service.CourseRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseRegisterServiceImpl implements CourseRegisterService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final CourseRegisterDao courseRegisterDao = new CourseRegisterDaoImpl();

    @Override
    public void create(CourseRegister courseRegister) {
        if(isCourseRegisterNotNull(courseRegister)) {
            LOGGER_INFO.info("Start create courseRegister: " + courseRegister.getId());
            courseRegisterDao.create(courseRegister);
            LOGGER_INFO.info("End create courseRegister: " + courseRegister.getId());
        }
    }

    @Override
    public void update(CourseRegister courseRegister) {
        if(isCourseRegisterNotNull(courseRegister)) {
            LOGGER_WARN.warn("Start update courseRegister: " + courseRegister.getId());
            courseRegisterDao.update(courseRegister);
            LOGGER_WARN.warn("End update courseRegister: " + courseRegister.getId());
        }
    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn(("Start delete courseRegister ID:" + id));
        courseRegisterDao.delete(id);
        LOGGER_WARN.warn(("End delete courseRegister ID:" + id));
    }

    @Override
    public CourseRegister findById(String id) {
        return courseRegisterDao.findById(id);
    }

    @Override
    public CourseRegister[] findAll() {
        return courseRegisterDao.findAll();
    }

    private boolean isCourseRegisterNotNull(CourseRegister courseRegister){
        if(courseRegister != null){
            if(courseRegister.getCourse() == null || courseRegister.getStudent() == null){
                LOGGER_ERROR.error("CourseRegister: student or course cant be null");
                return false;
            }
            return true;
        } else {
            LOGGER_ERROR.error("CourseRegister cant be null");
            return false;
        }
    }
}
