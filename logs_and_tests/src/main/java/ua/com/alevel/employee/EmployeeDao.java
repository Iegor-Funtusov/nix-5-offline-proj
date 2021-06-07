package ua.com.alevel.employee;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmployeeDao {
    Employee[] employers = new Employee[10];

    public void create(Employee employee) {

        employee.setId((UUID.randomUUID().toString()));
        Employee[] employeesAdded = new Employee[employers.length + 1];
        employeesAdded[employers.length] = employee;
        System.arraycopy(employers, 0, employeesAdded, 0, employers.length);
        employers = employeesAdded;
    }

    public Employee[] readAll() {
        System.out.println(Arrays.stream(employers)
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );
        return employers;
    }


    public void update(Employee employee) {
        Employee currentEmployee = findById(employee.getId());
        try {
            BeanUtils.copyProperties(currentEmployee, employee);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
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
        for (Employee employee : employers) {
            if (employee.getId().equalsIgnoreCase(id))
                return employee;
        }
        return null;
    }
}
