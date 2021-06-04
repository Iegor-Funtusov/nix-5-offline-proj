package ua.com.alevel.employee;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.alevel.department.Department;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class EmployeeDao {

    Employee[] employers = new Employee[10];

    public void create(Employee employee) {
        if (employee!= null)
            employee.setId(generateId(employee.getId()));
        Employee[] employeesForSave = new Employee[employers.length + 1];
        employeesForSave[employers.length] = employee;
        System.arraycopy(employers, 0, employeesForSave, 0, employers.length);
        employers = employeesForSave;
    }

    public Employee[] readAll() {
        return employers;
    }

    public void update(Employee employee) {
        Employee currentEmployers = findById(employee.getId());
        try {
            BeanUtils.copyProperties(currentEmployers, employee);
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

    public Employee findById(String id) {
        if (id != null) {
            for (Employee employee : employers) {
                if (employee.getId().equals(id)){
                    return employee;
                }
            }
        }
        return null;
    }



    public String generateId(String id) {
        if (id != null || !id.isEmpty()) {
            UUID uniqueId = UUID.randomUUID();
            return uniqueId.toString();
        }
        return "Вы ввели что-то неправильно";
    }
}
