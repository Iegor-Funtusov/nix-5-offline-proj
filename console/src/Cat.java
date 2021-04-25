
public class Cat {
    String name;
    int age;

    public static void main(String[] args) {
        Cat tommy = new Cat();
        tommy.age = 2;
        tommy.name = "Томми";

        System.out.println("Мы создали кота по имени " + tommy.name + ", его возраст - " + tommy.age);
    }
}
