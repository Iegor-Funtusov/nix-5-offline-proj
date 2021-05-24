package com.example.deanery.dao.impl;

import com.example.deanery.dao.StudentDao;
import com.example.deanery.model.Student;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Arrays;
import java.util.UUID;

public class StudentDaoImpl implements StudentDao {
    private int sizeOfEntities = 8;
    private int indexOfEntities = 0;

    private Student[] entities = new Student[sizeOfEntities];

    @Override
    public void create(Student student) {
        if(indexOfEntities + 1 > entities.length){
            increaseEntities();
        }
        student.setId(generateId(UUID.randomUUID().toString()));
        entities[indexOfEntities] = student;
        indexOfEntities++;
    }


    @Override
    public void update(Student student){
        Student current = findById(student.getId());
        try {
            BeanUtils.copyProperties(current, student);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(String id){
        Student student = findById(id);
        student.setDeleted(true);
    }

    @Override
    public Student findById(String id){
        for(Student s : entities){
            if(s != null){
                if(!s.isDeleted() && s.getId().equals(id)){
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public Student[] findAll() {
        return Arrays.stream(entities)
                .filter(e -> e != null && !e.isDeleted())
                .toArray(Student[]::new);
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
