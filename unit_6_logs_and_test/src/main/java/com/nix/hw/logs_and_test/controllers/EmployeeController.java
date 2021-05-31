package com.nix.hw.logs_and_test.controllers;

import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.models.Employee;
import com.nix.hw.logs_and_test.services.EmployeeService;

import java.util.List;

public class EmployeeController {

    private final EmployeeService employeeService = new EmployeeService();

    public void create(Employee employee) {
        employeeService.create(employee);
    }

    public Employee readById(String id) {
        return employeeService.findById(id);
    }

    public Employee readByName(String name) {
        return employeeService.findByName(name);
    }

    public List<Employee> readByDepartment(Department department) {
        return employeeService.findByDepartment(department);
    }

    public List<Employee> readAll() {
        return employeeService.findAll();
    }

    public void update(Employee employee) {
        employeeService.update(employee);
    }

    public void delete(String id) {
        employeeService.delete(id);
    }

}
