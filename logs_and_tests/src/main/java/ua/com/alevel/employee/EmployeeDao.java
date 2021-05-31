package ua.com.alevel.employee;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class EmployeeDao {

    Employee[] employers = new Employee[10];

    public void create(Employee employee) {
        if (employee != null)
        employee.setId(generateId(employee.getId()));
    }

    public Employee[] readAll() {
        return employers;
    }

    public void update(Employee employee) {
        String current = findById(employee.getId());
        try {
            BeanUtils.copyProperties(current, employee);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.getMessage();
        }
    }


    public void delete(String id) {
        for(int i = 0; i < employers.length; i++) {
            if(employers[i].getId().equals(id)) {
                employers[i] = null;
                break;
            }
        }
    }

    public String findById(String id) {
        for (int i = 0; i < employers.length; i++) {
            if (employers[i].getId().equals(id))
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
