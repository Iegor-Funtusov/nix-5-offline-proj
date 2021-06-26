package dataclasses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntityWrapper<T> {
    private T entity;
    private boolean isDeleted;

    @Override
    public String toString() {
        if (isDeleted) {
            return entity + " DELETE";
        }
        return entity.toString();
    }
}