package ua.practice.console;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        
        Person person1 = new Student("Cierra", "Vega", 18);
        Person person2 = new Student("Alden", "Cantrell", 19);
        Person person3 = new Teacher("Kierra", "Gentry", 28);
        Person person4 = new Student("Pierre", "Cox", 28);
        Person person5 = new Student("Thomas", "Crane", 19);
        Person person6 = new Student("Tiranda", "Shaffer", 19);
        Person person7 = new Teacher("Bradyn", "Kramer", 45);
        Person person8 = new Student("Alvaro", "Mcgee", 18);
        
        container.addToList(person1);
        container.addToList(person2);
        container.addToList(person3);
        container.addToList(person4);
        container.addToList(person5);
        container.addToList(person6);
        container.addToList(person7);
        container.addToList(person8);
        
        container.print();
        System.out.println(CombinatoricsUtils.factorial(5));
    }
}
