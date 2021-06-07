package ua.com.alevel.UI;

import ua.com.alevel.employee.Employee;
import ua.com.alevel.employee.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeUI {
    public void runEmployeeUI() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EmployeeService employeeService = new EmployeeService();

        while (true) {
            printOptions();
            String choose = reader.readLine();
            switch (choose){
                case "1":

                    Employee employee = new Employee();
                    System.out.println("Введите имя сотрудника: ");
                    String employeeName = reader.readLine();
                    if (employeeName.isBlank()) {
                        System.out.println("Неправильно, введите ещё раз.");
                        return;
                    }
                    employee.setName(employeeName);
                    employeeService.create(employee);
                    break;

                case "2":

                    System.out.println("Введите ID для обновления");

                    String id = reader.readLine();
                    employee = employeeService.findById(id);

                    System.out.println("Введите новое имя сотрудника");
                    String newEmployeeName = reader.readLine();

                    if (newEmployeeName.isBlank()){
                        System.out.println("Неправильно, введите ещё раз.");
                        return;
                    }

                    employee.setName(newEmployeeName);
                    employeeService.update(employee);
                    break;

                case "3":
                    System.out.println("Enter id");
                    String id2 = reader.readLine();
                    if (id2.isBlank()) {
                        System.out.println("Неправильно, введите ещё раз.");
                        return;
                    }
                    employeeService.delete(id2);
                    break;

                case "4":
                    Employee[] employers = employeeService.readAll();
                    System.out.println(employers);
                    break;

                case "5":
                    System.out.println("Введите ID департамента для поиска");
                    String id3 = reader.readLine();
                    Employee employee1 = employeeService.findById(id3);
                    System.out.println(employee1);
                    break;

                case "0":
                    System.exit(0);
                    break;
            }




        }

    }



    public void printOptions() {
        System.out.println("Выберите операцию: 1 - Создать сотрудника \n" +
                "2 - Обновить сотрудника \n3 - удалить сотрудника \n4 - Вывести всех сотруников\n" +
                "5 - Найти сотрудника по ID \n0 - Выйти в главное меню");
    }
}
