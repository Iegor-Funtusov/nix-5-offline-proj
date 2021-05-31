package ua.com.alevel.department;

import ua.com.alevel.department.DepartmentDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private DepartmentDao departmentDao = new DepartmentDao();

    public void create(Department department) {
        LOGGER_INFO.info("Start create department: " + department.getName());
        if (department != null) {
            departmentDao.create(department);
        }
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

    public String findById(String id) {
        if (departmentDao.findById(id) != null) {
            LOGGER_ERROR.error("This department is exist");
            return departmentDao.findById(id);
        }
        LOGGER_ERROR.error("This department doest not exist");
        return "Введены неправильные данные";
    }

    public String generateId(String id) {
        return departmentDao.generateId(id);
    }
}
