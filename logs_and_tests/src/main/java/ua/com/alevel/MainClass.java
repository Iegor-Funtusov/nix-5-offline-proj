package ua.com.alevel;

import ua.com.alevel.department.Department;
import ua.com.alevel.department.DepartmentDao;
import ua.com.alevel.department.DepartmentService;
import ua.com.alevel.employee.Employee;
import ua.com.alevel.employee.EmployeeDao;

public class MainClass {

    public static void main(String[] args) {
        DepartmentDao departmentDao = new DepartmentDao();
        Department department = null;
        departmentDao.create(department);
        System.out.println("department = " + department);
        departmentDao.delete(String.valueOf(department));
        System.out.println("department = " + department);
    }
}
