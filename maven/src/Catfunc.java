public class Catfunc {
    String name;
    int age;

    public void sayMeow() {
        System.out.println("Мяу!");
    }

    public void jump() {
        System.out.println("Прыг-скок!");
    }

    public static void main(String[] args) {
        Catfunc tommy = new Catfunc();
        tommy.age = 3;
        tommy.name = "Томми";

        tommy.sayMeow();
        tommy.jump();

    }
}
