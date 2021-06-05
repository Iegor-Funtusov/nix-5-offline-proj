package com.nix.hw.logs_and_test.controllers;

import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.services.DepartmentService;

import java.util.List;

public class DepartmentController {

    private final DepartmentService departmentService = new DepartmentService();

    public void create(Department department) {
        departmentService.create(department);
    }

    public Department readById(String id) {
        return departmentService.findById(id);
    }

    public Department readByName(String name) {
        return departmentService.findByName(name);
    }

    public List<Department> readAll() {
        return departmentService.findAll();
    }

    public void update(Department department) {
        departmentService.update(department);
    }

    public void delete(String id) {
        departmentService.delete(id);
    }

}
