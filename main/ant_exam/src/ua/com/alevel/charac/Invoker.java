package ua.com.alevel.charac;


public class Invoker extends Character {
    public Invoker() {
        this.name = "Invoker";
    }

    public void sunstrike(Character character) {
        System.out.println("Даю санстрайк по " + character.name);
    }
}