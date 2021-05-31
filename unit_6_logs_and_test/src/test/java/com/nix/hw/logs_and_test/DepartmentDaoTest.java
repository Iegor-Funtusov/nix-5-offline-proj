package com.nix.hw.logs_and_test;

import com.nix.hw.logs_and_test.dao.DepartmentDao;
import com.nix.hw.logs_and_test.models.Department;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentDaoTest {

    private static DepartmentDao departmentDao = new DepartmentDao();

    @Test
    @Order(1)
    public void create() {

        Department department1 = new Department();
        department1.setName("testDepartment1");

        Department department2 = new Department();
        department2.setName("testDepartment2");

        departmentDao.create(department1);
        departmentDao.create(department2);

        Assert.assertTrue(departmentDao.findAll().size() == 2);
    }

    @Test
    @Order(2)
    public void delete() {

        Department department = new Department();
        department.setName("testName1");
        departmentDao.create(department);
        Assert.assertTrue(departmentDao.findAll().size() == 3);
        departmentDao.delete(department.getId());
        Assert.assertTrue(departmentDao.findAll().size() == 2);
    }


    @Test
    @Order(3)
    public void update() {

        Department department = departmentDao.findByName("testDepartment1");
        department.setName("newTestName");
        departmentDao.update(department);

        Assert.assertEquals("newTestName", department.getName());

        department.setEmployees(new ArrayList<>());

        departmentDao.update(department);

        Assert.assertTrue(departmentDao
                .findByName("newTestName")
                .getEmployees()
                .size() == 0);
    }

    @Test
    @Order(4)
    public void findAll() {
        List<Department> list = departmentDao.findAll();
        Assert.assertTrue(departmentDao.findAll().size() == 2);
    }

    @Test
    @Order(5)
    public void findByName() {
        Department department = departmentDao.findByName("newTestName");
        Assert.assertTrue(department != null);
    }
}
