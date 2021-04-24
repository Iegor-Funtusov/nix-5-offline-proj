package ua.practice.maven;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addSubscriber(new Subscriber("Pupkin", "+380999456"));
        phoneBook.addSubscriber(new Subscriber("Petrov", "+380993456"));
        phoneBook.addSubscriber(new Subscriber("Ivanov", "+380994456"));
        phoneBook.print();

        System.out.println(StringUtils.upperCase("Search by last name \"Ivanov\":"));
        List<String> telephones = phoneBook.searchByLastName("Ivanov");
        for (String telephone : telephones) {
            System.out.println(telephone);
        }
        System.out.println("Factorial 5!" + CombinatoricsUtils.factorial(5));
    }
}
