package ua.com.alevel.department;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Objects;
import java.util.UUID;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DepartmentDao {
    Department[] departments = new Department[0];

    public void create(Department department) {

        department.setId((UUID.randomUUID().toString()));
        Department[] departmentsAdded = new Department[departments.length + 1];
        departmentsAdded[departments.length] = department;
        System.arraycopy(departments, 0, departmentsAdded, 0, departments.length);
        departments = departmentsAdded;
    }

    public Department[] readAll() {
        System.out.println(Arrays.stream(departments)
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );
        return departments;
    }


    public void update(Department department) {
        Department currentDepartment = findById(department.getId());
        try {
            BeanUtils.copyProperties(currentDepartment, department);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
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

    public Department findById(String id) {
        for (Department department : departments) {
            if (department.getId().equalsIgnoreCase(id))
                return department;
        }
        return null;
    }

}
