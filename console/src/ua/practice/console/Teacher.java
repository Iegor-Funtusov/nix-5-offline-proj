package ua.practice.console;

public class Teacher extends Person{

    public Teacher(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    
    @Override
    public String getName() {
        return "ua.practice.console.Teacher: " + this.name + " " + this.lastName + " Age: " + this.age;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
