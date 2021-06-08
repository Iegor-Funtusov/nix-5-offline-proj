package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.employee.Employee;
import ua.com.alevel.employee.EmployeeDao;

public class EmployeeDaoTest {
    private static final String NAME = "test";
    private static final String NAME_UPDATE = "test5";
    private static final EmployeeDao employeeDao = new EmployeeDao();

//    @BeforeAll
//    public static void setUp() {
//        for (int i = 0; i < 10; i++) {
//            Employee employee = new Employee();
//            employee.setName(NAME + i);
//            employeeDao.create(employee);
//        }
//        Employee[] employers = employeeDao.readAll();
//        Assertions.assertTrue(employers != null && employers.length == 10);
//
//    }

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setName(NAME + i);
            employeeDao.create(employee);
        }


        Employee[] employers = employeeDao.readAll();
        Assertions.assertEquals(employers != null, employers.length == 10);
    }

    @Test
    @Order(2)
    public void delete() {
        Employee[] employers = employeeDao.readAll();
        String id = employers[2].getId();
        employeeDao.delete(id);
        Assertions.assertNotNull(employeeDao.readAll());
    }

    @Test
    @Order(3)
    public void update() {
        Employee[] employers = employeeDao.readAll();
        Employee employee = employeeDao.findById(employers[1].getId());
        employee.setName(NAME_UPDATE);
        employeeDao.update(employee);

        Assertions.assertEquals(employers[1].getName(), NAME_UPDATE);
    }
}
