package com.example.deanery.service.impl;

import com.example.deanery.dao.StudentDao;
import com.example.deanery.dao.impl.StudentDaoImpl;
import com.example.deanery.model.Student;
import com.example.deanery.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void create(Student student) {
        if(isStudentNotNull(student)) {
            LOGGER_INFO.info("Start create student: " + student.getLastName());
            studentDao.create(student);
            LOGGER_INFO.info("End create student: " + student.getLastName());
        }
    }

    @Override
    public void update(Student student) {
        if(isStudentNotNull(student)) {
            LOGGER_WARN.warn("Start update student: " + student.getId());
            studentDao.update(student);
            LOGGER_WARN.warn("End update student: " + student.getId());
        }
    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn(("Start delete student ID:" + id));
        studentDao.delete(id);
        LOGGER_WARN.warn(("End delete student ID:" + id));
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public Student[] findAll() {
        return studentDao.findAll();
    }

    private boolean isStudentNotNull(Student student){
        if(student != null){
            return true;
        } else {
            LOGGER_ERROR.error("Student cant be null");
            return false;
        }
    }
}
