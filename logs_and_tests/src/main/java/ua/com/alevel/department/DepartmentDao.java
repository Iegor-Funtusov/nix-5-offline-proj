package ua.com.alevel.department;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.Arrays;

public class DepartmentDao {
    Department[] departments = new Department[10];

    public void create(Department department) {
        department.setId(generateId(department.getId()));
        Department[] departmentsForSave = new Department[departments.length + 1];
        departmentsForSave[departments.length] = department;
        System.arraycopy(departments, 0, departmentsForSave, 0, departments.length);
        departments = departmentsForSave;
    }

    public Department[] readAll() {
        return departments;
    }

    public void update(Department department) {
        Department currentDepartment = findById(department.getId());
        try {
            BeanUtils.copyProperties(currentDepartment, department);
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

    public Department findById(String id) {
            for (Department department : departments) {
                    return department;
            }
        return null;
    }
    
    public String generateId(String id) {
            UUID uniqueId = UUID.randomUUID();
            return uniqueId.toString();
    }
}
