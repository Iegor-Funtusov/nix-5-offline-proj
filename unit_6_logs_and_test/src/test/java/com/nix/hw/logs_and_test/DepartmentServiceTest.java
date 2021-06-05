package com.nix.hw.logs_and_test;

import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.models.Employee;
import com.nix.hw.logs_and_test.services.DepartmentService;
import com.nix.hw.logs_and_test.services.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentServiceTest {

    private static DepartmentService departmentService = new DepartmentService();
    private static EmployeeService employeeService = new EmployeeService();

    @Test
    @Order(1)
    public void create() {

        Department department = new Department();

        department.setName("d1");
        department.setEmployees(new ArrayList<>());
        departmentService.create(department);

        department = new Department();
        department.setName("d2");
        department.setEmployees(new ArrayList<>());
        departmentService.create(department);

        Assert.assertTrue(departmentService.findAll().size() == 2);
    }

    @Test
    @Order(2)
    public void update() {

        Department department = new Department();

        department.setName("d3");
        department.setEmployees(new ArrayList<>());
        departmentService.create(department);

        for (int i = 0; i < 3; i++) {
            Employee employee = new Employee();
            employee.setName("d3e" + i);
            employee.setDepartment(department);
            employeeService.create(employee);
        }

        Assert.assertEquals(3, departmentService
                .findByName("d3")
                .getEmployees()
                .size());


        department.setName("new_d1");
        departmentService.update(department);

        Assert.assertTrue(departmentService.findByName("new_d1") != null);
    }

    @Test
    @Order(3)
    public void delete() {

        Department department = new Department();
        department.setName("test");
        departmentService.create(department);
        Assert.assertTrue(departmentService.findAll().size() == 4);

        departmentService.delete(department.getId());
        Assert.assertTrue(departmentService.findAll().size() == 3);
    }

    @Test
    @Order(4)
    public void findAll() {
        Assert.assertTrue(departmentService.findAll().size() == 3);
    }

    @Test
    @Order(4)
    public void findById() {
        Department department = departmentService.findByName("new_d1");
        Assert.assertTrue(departmentService.findById(department.getId()) != null);
    }

    @Test
    @Order(5)
    public void findByName() {
        Assert.assertTrue(departmentService.findByName("new_d1")!=null);
    }

}
