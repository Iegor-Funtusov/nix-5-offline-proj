package ua.com.alevel;

import ua.com.alevel.employee.Employee;
import ua.com.alevel.employee.EmployeeDao;

public class MainClass {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = new Employee();
        employee.setName("Name");
        employee.setId("1");
        employeeDao.create(employee);
        System.out.println(employee);
    }
}
