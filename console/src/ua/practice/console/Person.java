package ua.practice.console;

public abstract class Person implements Comparable<Person>{
    protected String name;
    protected String lastName;
    protected int age;

    public abstract String getName();
}
