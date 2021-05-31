package com.nix.hw.logs_and_test.services;

import com.nix.hw.logs_and_test.dao.EmployeeDao;
import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeService {

    private static final Logger LOGGER_INFO  = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN  = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final EmployeeDao employeeDao = new EmployeeDao();
    private final DepartmentService departmentService = new DepartmentService();

    public void create(Employee employee) {
        LOGGER_INFO.info("Start creating employee: " + employee.getName());
        if (employee.getName().isBlank() ||
                employee.getDepartment() == null) {
            LOGGER_ERROR.error("Empty value");
            return;
        }

        if (!isEmployeeExistsByName(employee.getName())) {
            employeeDao.create(employee);
            Department department = employee.getDepartment();
            department.setEmployees(employeeDao.findByDepartment(employee.getDepartment()));
            departmentService.update(department);
        }

        LOGGER_INFO.info("End creating employee");
    }

    public void update(Employee employee) {
        LOGGER_WARN.warn("Start updating employee: " + employee.getName());
        if (employee.getName().isBlank() ||
                employee.getId().isBlank()) {
            LOGGER_ERROR.error("Empty value");
            return;
        }

        if (isEmployeeExistsById(employee.getId())) {
            employeeDao.update(employee);
            Department department = employee.getDepartment();
            department.setEmployees(employeeDao.findByDepartment(department));
            departmentService.update(department);
        }

        LOGGER_WARN.warn("End updating employee");
    }

    public void delete(String id) {
        LOGGER_WARN.warn("Start deleting employee with id: " + id);
        if (isEmployeeExistsById(id)) {
            Employee currentEmployee = findById(id);
            employeeDao.delete(id);
            Department department = currentEmployee.getDepartment();
            department.setEmployees(employeeDao.findByDepartment(department));
            departmentService.update(department);

        }
        LOGGER_WARN.warn("End deleting employee");
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public List<Employee> findByDepartment(Department department) {
        if (department == null) {
            return null;
        }
        return employeeDao.findByDepartment(department);
    }

    public Employee findById(String id) {
        if (id.isBlank())
            return null;
        return employeeDao.findById(id);
    }

    public Employee findByName(String name) {
        if (name.isBlank())
            return null;
        return employeeDao.findByName(name);
    }

    private boolean isEmployeeExistsById(String id) {
        if (!id.isBlank()) {
            return findById(id) != null;
        }
        return false;
    }

    private boolean isEmployeeExistsByName(String name) {
        if (!name.isBlank()) {
            return findByName(name) != null;
        }
        return false;
    }
}
