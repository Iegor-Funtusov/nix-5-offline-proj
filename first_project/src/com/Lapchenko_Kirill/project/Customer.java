package com.Lapchenko_Kirill.project;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Customer {
    private String Name;
    private int Age;

    public Customer(String name, int age) {
        setName(name);
        setAge(age);
    }
}
