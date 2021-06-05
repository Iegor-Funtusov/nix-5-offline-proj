package com.nix.hw.logs_and_test.dao;

import com.nix.hw.logs_and_test.models.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartmentDao {

    private final List<Department> departments = new ArrayList<>();

    public void create(Department department) {
        department.setId(generateId(UUID.randomUUID().toString()));
        departments.add(department);
    }

    public void update(Department department) {
        department.setName(department.getName());
        department.setEmployees(department.getEmployees());
    }

    public void delete(String id) {
        departments.removeIf(d -> d.getId().equals(id));
    }

    public List<Department> findAll() {
        return departments;
    }

    public Department findByName(String name) {
        return departments.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Department findById(String id) {
        return departments.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    private String generateId(String id) {
        if (departments.stream().anyMatch(d -> d.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
}
