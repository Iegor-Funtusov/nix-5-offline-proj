package com.Lapchenko_Kirill.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomerInfo customerInfo = new CustomerInfo();
        String input;
        Integer i;
        do{
            printMenu();
            input = reader.readLine();
            i = Ints.tryParse(input);
            Preconditions.checkNotNull(i, "Input cannot be empty!!!");
            switch (i) {
                case 1:
                    customerInfo.printAllInfo();
                    break;
                case 2:
                    System.out.println("Enter age: ");
                    Integer age = Ints.tryParse(reader.readLine());
                    System.out.println("Enter name: ");
                    String name = reader.readLine();
                    customerInfo.addCustomer(name, age);
                    System.out.println("Customer was added!");
                    break;
                case 3:
                    System.out.println("Enter id of customer which you want to remove:");
                    Integer id = Ints.tryParse(reader.readLine());
                    customerInfo.removeCustomer(id);
                    break;
            }
        }while (i != 4);
    }

    private static void printMenu(){
        System.out.println("----------------" +
                "\n Choose Action:\n" +
                        "1 - Print all customers\n" +
                        "2 - Add new Customer\n" +
                        "3 - Remove Customer by id\n" +
                        "4 - To exit\n" + 
			"----------------"
			);
    }

}
