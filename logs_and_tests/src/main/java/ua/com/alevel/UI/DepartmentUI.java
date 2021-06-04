package ua.com.alevel.UI;

import ua.com.alevel.department.Department;
import ua.com.alevel.department.DepartmentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepartmentUI {

    public void runDepartmentUI() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DepartmentService departmentService = new DepartmentService();

        while (true) {
            printOptions();
            String choose = reader.readLine();
            switch (choose){
                case "1":

                    Department department = new Department();
                    System.out.println("Введите название департамента: ");
                    String departmentName = reader.readLine();
                    if (departmentName.isBlank()) {
                        System.out.println("Неправильно, введите ещё раз.");
                        return;
                    }
                    department.setName(departmentName);
                    departmentService.create(department);
                    break;

                case "2":

                    System.out.println("Введите ID для обновления");

                    String id = reader.readLine();
                    department = departmentService.findById(id);

                    System.out.println("Введите новое название департамента");
                    String newDepartmentName = reader.readLine();

                    if (newDepartmentName.isBlank()){
                        System.out.println("Неправильно, введите ещё раз.");
                        return;
                    }

                    department.setName(newDepartmentName);
                    departmentService.update(department);
                    break;

                case "3":
                    System.out.println("Enter id");
                    String id2 = reader.readLine();
                    if (id2.isBlank()) {
                        System.out.println("Неправильно, введите ещё раз.");
                        return;
                    }
                    departmentService.delete(id2);
                    break;

                case "4":
                    Department[] departments = departmentService.readAll();
                    System.out.println(departments);
                    break;

                case "5":
                    System.out.println("Введите ID департамента для поиска");
                    String id3 = reader.readLine();
                    Department department2 = departmentService.findById(id3);
                    System.out.println(department2);
                    break;

                case "0":
                    System.exit(0);
                    break;
            }




        }

    }




    public void printOptions() {
        System.out.println("Выберите операцию: 1 - Создать департамент \n" +
                "2 - Обновить департамент \n3 - удалить департамент \n4 - Вывести все департаменты\n" +
                "5 - Найти департамент по ID \n0 - Выйти в главное меню");
    }
}
