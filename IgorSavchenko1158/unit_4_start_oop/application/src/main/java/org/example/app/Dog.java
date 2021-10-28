package org.example.app;

import org.example.lib.BaseEntity;

public class Dog extends BaseEntity {

    private String name;
    private String breed;

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public Dog setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
