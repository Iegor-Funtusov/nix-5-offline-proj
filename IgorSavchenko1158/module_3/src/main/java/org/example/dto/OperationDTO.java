package org.example.dto;

import org.example.entity.Category;

import java.time.Instant;

public class OperationDTO {
    private Long sum;
    private Instant time;
    private String name;
    private String description;
    private Category.CategoryType type;

    public OperationDTO(Long sum, Instant time, String name, String description, Category.CategoryType type) {
        this.sum = sum;
        this.time = time;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category.CategoryType getType() {
        return type;
    }

    public void setType(Category.CategoryType type) {
        this.type = type;
    }
}
