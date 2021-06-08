package ua.com.alevel;

import ua.com.alevel.UI.DepartmentUI;
import ua.com.alevel.UI.EmployeeUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            printMainOptions();
            String choose = null;

            try {
                choose = reader.readLine();
            } catch (IOException e) {
                e.getMessage();
            }

            switch (choose) {

                case "1":
                    DepartmentUI departmentUI = new DepartmentUI();
                    try {
                        departmentUI.runDepartmentUI();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    break;

                case "2":

                    EmployeeUI employeeUI = new EmployeeUI();
                    try {
                        employeeUI.runEmployeeUI();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    break;

                case "3":

                    System.exit(0);

            }
        }
    }





    public static void printMainOptions() {
        System.out.println("Введите что бы вы хотели сделать:\n" +
                "1 - CRUD департаментов \n2 - CRUD сотрудников \n0 - выйти из программы.");
    }
}
