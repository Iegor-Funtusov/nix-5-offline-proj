package dataclasses;

import lombok.Data;

@Data
public class EntityWrapper<T> {
    private T entity;
    private boolean isDeleted = false;

}