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
    public void update(Student student) {
        Student current = findById(student.getId());
        try {
            BeanUtils.copyProperties(current, student);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        for(int i = 0; i < indexOfEntities; i++){
            if(entities[i].getId().equals(id)){
                entities[i] = null;
                indexOfEntities--;
                for(int j = i+1; j < indexOfEntities+1; j++){
                    entities[j-1] = entities[j];
                    entities[j] = null;
                }
            }
        }
    }

    @Override
    public Student findById(String id) {
        for(Student s : entities){
            if(s.getId().equals(id)){
                return s;
            }
        }
        throw new RuntimeException("entity not exist");
    }

    @Override
    public Student[] findAll() {
        return entities;
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
