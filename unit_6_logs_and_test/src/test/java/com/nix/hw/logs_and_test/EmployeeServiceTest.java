package com.nix.hw.logs_and_test;

import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.models.Employee;
import com.nix.hw.logs_and_test.services.DepartmentService;
import com.nix.hw.logs_and_test.services.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTest {

    private static EmployeeService employeeService = new EmployeeService();
    private static DepartmentService departmentService = new DepartmentService();
    static Department department = new Department();

    @BeforeAll
    public static void setUp() {

        department.setName("d1");
        department.setEmployees(new ArrayList<>());
        departmentService.create(department);
    }

    @Test
    @Order(1)
    public void create() {

        for (int i = 0; i < 3; i++) {
            Employee employee = new Employee();
            employee.setName("d1e" + i);
            employee.setDepartment(department);
            employeeService.create(employee);
        }

        Assert.assertEquals(3, departmentService
                .findByName("d1")
                .getEmployees()
                .size());
    }

    @Test
    @Order(2)
    public void update() {

        Employee employee = employeeService.findByName("d1e1");
        employee.setName("updName");
        employeeService.update(employee);

        Assert.assertTrue(department.getEmployees().size() == 3 &&
                employeeService.findByName("updName") != null
        );
    }

    @Test
    @Order(3)
    public void delete() {

        Employee employee = employeeService.findByName("updName");
        employeeService.delete(employee.getId());

        Assert.assertTrue(department.getEmployees().size() == 2 &&
                employeeService.findAll().size() == 2);
    }

    @Test
    @Order(4)
    public void findAll() {
        Assert.assertTrue(employeeService.findAll().size() == 2);
    }

    @Test
    @Order(5)
    public void findById() {
        Employee employee = employeeService.findByName("d1e0");
        Assert.assertTrue(employeeService.findById(employee.getId()) != null);
    }

    @Test
    @Order(6)
    public void findByName() {
        Assert.assertTrue(employeeService.findByName("d1e0") != null);
    }

    @Test
    @Order(7)
    public void findByDepartment() {
        Assert.assertTrue(employeeService.findByDepartment(department).size()==2);
    }
}
