package com.nix.hw.logs_and_test.dao;

import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class EmployeeDao {

    private final List<Employee> employees = new ArrayList<>();

    public void create(Employee employee) {
        employee.setId(generateId(UUID.randomUUID().toString()));
        employees.add(employee);
    }

    public void update(Employee employee) {
        Employee currentEmploy = findById(employee.getId());
        currentEmploy.setName(employee.getName());
        currentEmploy.setDepartment(employee.getDepartment());
    }

    public void delete(String id) {
        employees.removeIf(e -> e.getId().equals(id));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findByName(String name) {

            for (Employee employee1 : employees) {
                if (employee1.getName() == name) {
                    return employee1;
                }
            }

            return employees.stream()
                            .filter(e -> e.getName().equals(name))
                            .findFirst()
                            .orElse(null);
    }


    public List<Employee> findByDepartment(Department department) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (Objects.equals(employee.getDepartment(), department)) {
                list.add(employee);
            }
        }
        return list;
    }

    public Employee findById(String id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    private String generateId(String id) {
        if (employees.stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

}
