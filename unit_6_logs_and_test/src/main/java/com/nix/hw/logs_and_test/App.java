package com.nix.hw.logs_and_test;

import com.nix.hw.logs_and_test.controllers.DepartmentController;
import com.nix.hw.logs_and_test.controllers.EmployeeController;
import com.nix.hw.logs_and_test.models.Department;
import com.nix.hw.logs_and_test.models.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {

    private static final EmployeeController employeeController = new EmployeeController();
    private static final DepartmentController departmentController = new DepartmentController();

    public static void run() {
        do {
            Utils.clearConsole();

            System.out.println("\n1 - Employee" +
                    "\n2 - Department" +
                    "\n3 - Exit\n");

            int choice = Utils.correctIntInput("Enter the number: ");

            switch (choice) {
                case 1:
                    manageEmployees();
                    break;
                case 2:
                    manageDepartments();
                    break;
                case 3:
                    System.exit(0);
                default:
                    Utils.clearConsole();
            }
        } while (true);
    }

    private static void manageEmployees() {

        if (departmentController.readAll() == null || departmentController.readAll().size() == 0) {
            System.out.println("There's no departments in system\nPlease add departments");
            Utils.pressEnter();
            return;
        }

        boolean flag = true;

        do {

            Utils.clearConsole();
            System.out.println("\nEmployees");
            System.out.println("\n1 - create" +
                    "\n2 - read all" +
                    "\n3 - update" +
                    "\n4 - delete" +
                    "\n5 - move back");
            int choice = Utils.correctIntInput("\nEnter the number: ");

            switch (choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    readAllEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    Utils.clearConsole();
            }
        } while (flag);
    }

    private static void createEmployee() {

        Utils.clearConsole();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter the employee's name: ");
            String employeeName = reader.readLine();

            System.out.print("\nEnter the department name: ");
            String departmentName = reader.readLine();

            if (employeeName.isBlank() || departmentName.isBlank()) {
                System.out.println("Name can't be blank");
                return;
            }

            Department department = departmentController.readByName(departmentName);
            if (department == null) {
                System.out.println("This department doesn't exist");
                Utils.pressEnter();
                return;
            }

            Employee employee = new Employee();
            employee.setName(employeeName);
            employee.setDepartment(department);

            employeeController.create(employee);

            System.out.println(employee.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void updateEmployee() {

        Utils.clearConsole();

        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter the employee's id: ");
            String employeeId = reader.readLine();

            if (employeeId.isBlank()) {
                System.out.println("Id can't be blank");
                return;
            }

            Employee employee = employeeController.readById(employeeId);
            if (employee == null) {
                return;
            }

            System.out.print("\nEnter new name: ");
            String newEmployeeName = reader.readLine();

            System.out.print("\nEnter new department: ");
            String newDepartmentName = reader.readLine();

            if (newDepartmentName.isBlank() || newEmployeeName.isBlank()) {
                System.out.println("Name can't be blank");
                return;
            }

            if (departmentController.readByName(newDepartmentName) == null) {
                System.out.println("This department doesn't exist");
                Utils.pressEnter();
                return;
            }

            employee.setName(newEmployeeName);
            employee.setDepartment(departmentController.readByName(newDepartmentName));

            employeeController.update(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void deleteEmployee() {

        Utils.clearConsole();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter the employee's id: ");
            String employeeId = reader.readLine();

            if (employeeId.isBlank()) {
                System.out.println("Id can't be blank");
                return;
            }

            Employee employee = employeeController.readById(employeeId);

            if (employee == null) {
                return;
            }

            employeeController.delete(employeeId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readAllEmployees() {
        Utils.clearConsole();
        List<Employee> list = employeeController.readAll();
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
        Utils.pressEnter();
    }

    private static void manageDepartments() {

        boolean flag = true;

        do {

            Utils.clearConsole();
            System.out.println("\nDepartments");
            System.out.println("\n1 - create" +
                    "\n2 - read all" +
                    "\n3 - update" +
                    "\n4 - delete" +
                    "\n5 - move back");
            int choice = Utils.correctIntInput("\nEnter the number: ");

            switch (choice) {
                case 1:
                    createDepartment();
                    break;
                case 2:
                    readAllDepartments();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    Utils.clearConsole();
            }
        } while (flag);
    }

    private static void createDepartment() {

        Utils.clearConsole();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter department name: ");
            String departmentName = reader.readLine();

            if (departmentName.isBlank()) {
                System.out.println("Name can't be blank");
                return;
            }

            Department department = new Department();
            department.setName(departmentName);

            departmentController.create(department);

            System.out.println(department.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void updateDepartment() {

        Utils.clearConsole();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter department id: ");
            String departmentId = reader.readLine();

            if (departmentId.isBlank()) {
                System.out.println("Id can't be blank");
                return;
            }

            Department department = departmentController.readById(departmentId);
            if (department == null) {
                System.out.println("This department doesn't exist");
                return;
            }
            System.out.print("\nEnter new department name: ");
            String newDepartmentName = reader.readLine();


            if (departmentController.readByName(newDepartmentName) == null) {
                return;
            }

            department.setName(newDepartmentName);

            departmentController.update(department);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void deleteDepartment() {

        Utils.clearConsole();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter department id: ");
            String departmentId = reader.readLine();

            if (departmentId.isBlank()) {
                System.out.println("Id can't be blank");
                return;
            }

            Department department = departmentController.readById(departmentId);

            if (department == null) {
                return;
            }

            departmentController.delete(departmentId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readAllDepartments() {
        Utils.clearConsole();
        List<Department> list = departmentController.readAll();
        for (Department department : list) {
            System.out.println(department.toString());
        }
        Utils.pressEnter();
    }

}
