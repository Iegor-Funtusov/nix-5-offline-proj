package com.keyplate.project.app;

import com.keyplate.project.lib.ArrayListCrudService;
import com.keyplate.project.lib.BaseEntityContainer;
import com.keyplate.project.lib.CRUDService;

public class StudentDAO implements CRUDService<Student> {
    private ArrayListCrudService<Student> studentList = new ArrayListCrudService<>();


    @Override
    public void update(long id, Student entity) {
        studentList.update(id, entity);
    }

    @Override
    public void delete(long id) {
        studentList.delete(id);
    }

    @Override
    public void create(Student entity) {
        studentList.create(entity);
    }

    @Override
    public Student read(long id) {
        return studentList.read(id);
    }

    @Override
    public BaseEntityContainer<Student> readAll() {
        return studentList.readAll();
    }
}
