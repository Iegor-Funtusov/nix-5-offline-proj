package ua.com.alevel.charac;

public class Pudge extends Character {
    public Pudge() {
        this.name = "Pudge";
        this.hp = 700;
    }

    public void hook(Character character){
        System.out.println("Хукаю " + character.name);
        character.hp-=150;
    }
}
