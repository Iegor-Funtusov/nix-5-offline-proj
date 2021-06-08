package ua.com.alevel.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public void create(Employee employee) {
        LOGGER_INFO.info("Start create employee: " + employee.getName());
        employeeDao.create(employee);
        LOGGER_INFO.info("End create employee");
    }

    public Employee[] readAll() {
        return employeeDao.readAll();
    }

    public void update(Employee employee) {
        LOGGER_WARN.warn("Start update employee: " + employee.getName());
        if (employee != null) {
            employeeDao.update(employee); }
        LOGGER_WARN.warn("End update employee");
    }
    public void delete(String id) {
        if (id != null) {
            employeeDao.delete(id);
        }
        else {
            LOGGER_ERROR.error("This id does not exist");
        }
    }


    public Employee findById(String id) {
        return employeeDao.findById(id);
    }
}
