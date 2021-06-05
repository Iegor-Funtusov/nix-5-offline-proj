package com.nix.hw.logs_and_test;

import com.nix.hw.logs_and_test.dao.EmployeeDao;
import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.models.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTest {

    private static EmployeeDao employeeDao = new EmployeeDao();

    @Test
    @Order(1)
    public void create() {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setName("empl1");
        employee2.setName("empl2");

        employeeDao.create(employee1);
        employeeDao.create(employee2);

        Assert.assertTrue(employeeDao.findAll().size() == 2);
    }

    @Test
    @Order(2)
    public void update() {

        Department department1 = new Department();

        Employee employee3 = new Employee();
        employeeDao.create(employee3);

        employee3.setName("updName");
        employee3.setDepartment(department1);
        employeeDao.update(employee3);

        Assert.assertTrue(employee3.getName().equals("updName") &&
                employee3.getDepartment().equals(department1));
    }

    @Test
    @Order(3)
    public void delete() {


        Employee employee = employeeDao.findByName("updName");
        employeeDao.delete(employee.getId());

        Assert.assertTrue(employeeDao.findAll().size()==2);
    }

    @Test
    @Order(3)
    public void findByName() {

        Employee employee = employeeDao.findByName("empl2");
        Assert.assertTrue(employee!=null);
    }

    @Test
    @Order(4)
    public void findByDepartment() {
        Department department = new Department();
        Employee employee = new Employee();
        employee.setName("testName1");
        employee.setDepartment(department);
        employeeDao.create(employee);

        Assert.assertTrue(employeeDao.findByDepartment(department) != null);
    }

    @Test
    @Order(5)
    public void findById() {

        Employee employee = new Employee();
        employee.setName("testName");
        employeeDao.create(employee);

        Assert.assertTrue(employeeDao.findById(employee.getId())!=null);
    }
}
