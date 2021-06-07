package ua.com.alevel;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import ua.com.alevel.department.Department;
import ua.com.alevel.department.DepartmentDao;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentDaoTest {

    private static final String NAME = "test";
    private static final String NAME_UPDATE = "test5";
    private static DepartmentDao departmentDao = new DepartmentDao();

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Department department = new Department();
            department.setName(NAME + i);
            departmentDao.create(department);
        }
        Department[] departments = departmentDao.readAll();
        Assertions.assertTrue(departments != null && departments.length == 10);

    }

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Department department = new Department();
            department.setName(NAME + i);
            departmentDao.create(department);
        }


        Department[] departments = departmentDao.readAll();
        Assertions.assertEquals(20, departments.length);
    }

    @Test
    @Order(2)
    public void delete() {
        Department[] departments = departmentDao.readAll();
        String id = departments[2].getId();
        departmentDao.delete(id);
        departments = departmentDao.readAll();
        Assertions.assertEquals(20, departments.length);
    }

//     @Test
//    @Order(3)
//    public void update() {
//        Department department = departmentDao.findById();
//        department.setName(NAME_UPDATE);
//        departmentDao.update(department);
//
//        department = departmentDao.findById();
//
//        Assertions.assertEquals(department.getName(), NAME_UPDATE);
//    }




}
