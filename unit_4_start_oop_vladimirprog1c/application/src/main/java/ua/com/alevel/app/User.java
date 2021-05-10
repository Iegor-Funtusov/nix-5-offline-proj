package ua.com.alevel.app;

import ua.com.alevel.lib.BaseEntity;

public class User extends BaseEntity {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
