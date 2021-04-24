package ua.practice.console;

import java.util.ArrayList;
import java.util.Collections;

public class Container {
    private final ArrayList<Person> list = new ArrayList<>();
    public void addToList( Person p)
    {
        list.add(p);
        Collections.sort(list);
    }
    public void print()
    {
        for (Person person : list) {
            System.out.println(person.getName());
        }
    }
}
