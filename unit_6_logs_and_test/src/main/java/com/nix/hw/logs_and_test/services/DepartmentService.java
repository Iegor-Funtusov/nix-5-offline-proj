package com.nix.hw.logs_and_test.services;

import com.nix.hw.logs_and_test.dao.DepartmentDao;
import com.nix.hw.logs_and_test.models.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DepartmentService {

    private static final Logger LOGGER_INFO  = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN  = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final DepartmentDao departmentDao = new DepartmentDao();

    public void create(Department department) {
        LOGGER_INFO.info("Start creating department: " + department.getName());
        if (department.getName().isBlank()) {
            LOGGER_ERROR.error("Empty value");
            return;
        }
        if (!isDepartmentExistsByName(department.getName())) {
            departmentDao.create(department);
        }
        LOGGER_INFO.info("End creating department");
    }

    public void update(Department department) {
        LOGGER_WARN.warn("Start updating department: " + department.getName());
        if (department.getName().isBlank() ||
                department.getId().isBlank()) {
            LOGGER_ERROR.error("Empty value");
            return;
        }

        if (isDepartmentExistsById(department.getId()))
            departmentDao.update(department);

        LOGGER_WARN.warn("End updating department");

    }

    public void delete(String id) {
        LOGGER_WARN.warn("Start deleting department with id: " + id);
        if (isDepartmentExistsById(id)) {
            departmentDao.delete(id);
        }
        LOGGER_WARN.warn("End deleting department");
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    public Department findById(String id) {
        if (id.isBlank()) {
            return null;
        }
        return departmentDao.findById(id);
    }

    public Department findByName(String name) {
        if (name.isBlank()) {
            return null;
        }
        return departmentDao.findByName(name);
    }

    private boolean isDepartmentExistsById(String id) {
        if (!id.isBlank()) {
            return findById(id) != null;
        }
        return false;
    }

    private boolean isDepartmentExistsByName(String name) {
        if (!name.isBlank()) {
            return findByName(name) != null;
        }
        return false;
    }
}
