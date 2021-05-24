package com.example.deanery.dao.impl;

import com.example.deanery.dao.CourseRegisterDao;
import com.example.deanery.model.Course;
import com.example.deanery.model.CourseRegister;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Arrays;
import java.util.UUID;

public class CourseRegisterDaoImpl implements CourseRegisterDao {
    private int sizeOfEntities = 8;
    private int indexOfEntities = 0;

    private CourseRegister[] entities = new CourseRegister[sizeOfEntities];

    @Override
    public void create(CourseRegister courseRegister) {
        if(indexOfEntities + 1 > entities.length){
            increaseEntities();
        }
        courseRegister.setId(generateId(UUID.randomUUID().toString()));
        entities[indexOfEntities] = courseRegister;
        indexOfEntities++;
    }


    @Override
    public void update(CourseRegister courseRegister){
        CourseRegister current = findById(courseRegister.getId());
        try {
            BeanUtils.copyProperties(current, courseRegister);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(String id){
        CourseRegister courseRegister = findById(id);
        courseRegister.setDeleted(true);
    }

    @Override
    public CourseRegister findById(String id){
        for(CourseRegister courseRegister : entities){
            if(!courseRegister.isDeleted() && courseRegister.getId().equals(id)){
                return courseRegister;
            }
        }
        throw new RuntimeException("Entity is not exist");
    }

    @Override
    public CourseRegister[] findAll() {
        return Arrays.stream(entities)
                .filter(e -> e != null && !e.isDeleted())
                .toArray(CourseRegister[]::new);
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
