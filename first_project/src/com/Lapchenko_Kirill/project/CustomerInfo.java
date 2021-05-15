package com.Lapchenko_Kirill.project;

import java.util.ArrayList;

public class CustomerInfo {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void printAllInfo() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getName() + " " + customers.get(i).getAge() + "y.o.");
        }
    }

    public void addCustomer(String name, int age){
        customers.add(new Customer(name, age));
    }

    public void removeCustomer(int id){
        customers.remove(id);
    }
}
