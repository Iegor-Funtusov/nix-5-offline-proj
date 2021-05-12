package com.example.crudApp.model;

import com.example.crudlib.BaseEntity;

public class User extends BaseEntity {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName +'\''+
                '}';
    }
}
