package ua.com.alevel.department;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.alevel.employee.EmployeeDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class DepartmentDao {
    Department[] departments = new Department[10];
    EmployeeDao employeeDao = new EmployeeDao();

    public void create(Department department) {
        if (department != null)
        department.setId(generateId(department.getId()));
    }

    public Department[] readAll() {
        System.out.println("Введите что бы вы хотели вывести: \n1 - Список сотрудников предприятия \n" +
                "2 - Название предприятия");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            switch (reader.readLine()) {
                case "1":
                    System.out.println(employeeDao.readAll());
                    break;
                case "2":
                    System.out.println(departments);

            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return departments;
    }

    public void update(Department department) {
        String current = findById(department.getId());
        try {
            BeanUtils.copyProperties(current, department);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.getMessage();
        }
    }


    public void delete(String id) {
        for(int i = 0; i < departments.length; i++) {
            if(departments[i].getId().equals(id)) {
                departments[i] = null;
                break;
            }
        }
    }

    public String findById(String id) {
        for (int i = 0; i < departments.length; i++) {
            if (departments[i].getId().equals(id))
                return id;
        }
        return "Вы ввели что-то неправильное";
    }
    
    public String generateId(String id) {
        if (id != null || !id.isEmpty()) {
            UUID uniqueId = UUID.randomUUID();
            return uniqueId.toString();
        }
        return "Вы ввели что-то неправильно";
    }
}
