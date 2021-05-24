package com.example.deanery.dao.impl;

import com.example.deanery.dao.CourseDao;
import com.example.deanery.model.Course;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Arrays;
import java.util.UUID;

public class CourseDaoImpl implements CourseDao {
    private int sizeOfEntities = 8;
    private int indexOfEntities = 0;

    private Course[] entities = new Course[sizeOfEntities];

    @Override
    public void create(Course course) {
        if(indexOfEntities + 1 > entities.length){
            increaseEntities();
        }
        course.setId(generateId(UUID.randomUUID().toString()));
        entities[indexOfEntities] = course;
        indexOfEntities++;
    }


    @Override
    public void update(Course course){
        Course current = findById(course.getId());
        try {
            BeanUtils.copyProperties(current, course);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(String id){
        Course course = findById(id);
        course.setDeleted(true);
    }

    @Override
    public Course findById(String id){
        for(Course course : entities){
            if(course != null){
                if(!course.isDeleted() && course.getId().equals(id)){
                    return course;
                }
            }
        }
        return null;
    }

    @Override
    public Course findByName(String name){
        for (Course entity : entities) {
            if (entity != null) {
                if (!entity.isDeleted() && entity.getName().equals(name)) {
                    return entity;
                }
            }
        }
        return null;
    }

    @Override
    public Course[] findAll() {
        return Arrays.stream(entities)
                .filter(e -> e != null && !e.isDeleted())
                .toArray(Course[]::new);
    }

    private void increaseEntities(){
        sizeOfEntities = entities.length * 2;
        entities = Arrays.copyOf(entities, sizeOfEntities);
    }

    private String generateId(String id) {
        if (Arrays.stream(entities).filter(e -> e != null).anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
}
