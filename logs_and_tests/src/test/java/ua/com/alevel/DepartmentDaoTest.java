package ua.com.alevel;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import ua.com.alevel.department.Department;
import ua.com.alevel.department.DepartmentDao;

public class DepartmentDaoTest {

    private static final String NAME = "test";
    private static final String NAME_UPDATE = "test5";
    DepartmentDao departmentDao = new DepartmentDao();

//    @BeforeAll
//    public void setUp() {
//        for (int i = 0; i < 10; i++) {
//            Department department = new Department();
//            department.setName(NAME + i);
//            departmentDao.create(department);
//        }
//        Department[] departments = departmentDao.readAll();
//        Assert.assertTrue(departments != null && departments.length == 10);
//
//    }

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 5; i++) {
            Department department = new Department();
            department.setName(NAME + i);
            departmentDao.create(department);
        }


        Department[] departments = departmentDao.readAll();
        Assertions.assertEquals(5, departments.length);
    }

//    @Test
//    @Order(2)
//    public void delete() {
//        Department[] departments = departmentDao.readAll();
//        String id = departments[2].getId();
//        departmentDao.delete(id);
//        departments = departmentDao.readAll();
//        Assertions.assertEquals(4, departments.length);
//    }
//
//    @Test
//    @Order(3)
//    public void update() {
//        Department department = new Department();
//        department.setName(NAME);
//        departmentDao.create(department);
//
//        department.setName("New name");
//        departmentDao.update(department);
//
//        Assertions.assertEquals(department.getName(), departmentDao.readAll());
//    }




}
