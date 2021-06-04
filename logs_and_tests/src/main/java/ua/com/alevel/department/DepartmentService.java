package ua.com.alevel.department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private DepartmentDao departmentDao = new DepartmentDao();

    public void create(Department department) {
        LOGGER_INFO.info("Start create department: " + department.getName());
            departmentDao.create(department);
        LOGGER_INFO.info("End create department");
    }

    public Department[] readAll() {
        return departmentDao.readAll();
    }

    public void update(Department department) {
        LOGGER_WARN.warn("Start update department: " + department.getName());
        if (department != null) {
        departmentDao.update(department); }
        LOGGER_WARN.warn("End update department");
    }
    public void delete(String id) {
        departmentDao.delete(id);
    }

    public Department findById(String id) {
        return departmentDao.findById(id);
    }

    public String generateId(String id) {
        return departmentDao.generateId(id);
    }
}
