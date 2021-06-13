package com.keyplate.project.app;

import com.keyplate.project.lib.ArrayListCrudService;
import com.keyplate.project.lib.BaseEntityContainer;
import com.keyplate.project.lib.CRUDService;

public class CourseDAO implements CRUDService<Course> {
    private ArrayListCrudService<Course> courseList = new ArrayListCrudService<>();

    @Override
    public void update(long id, Course entity) {
        courseList.update(id, entity);
    }

    @Override
    public void delete(long id) {
        courseList.delete(id);
    }

    @Override
    public void create(Course entity) {
        courseList.create(entity);
    }

    @Override
    public Course read(long id) {
        return courseList.read(id);
    }

    @Override
    public BaseEntityContainer<Course> readAll() {
        return courseList.readAll();
    }

}
