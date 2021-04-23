package ua.com.alevel.charac;

import org.apache.commons.lang3.StringUtils;

public class Invoker extends Character {
    public Invoker() {
        this.name = "Invoker";
        this.hp = 500;
    }

    public void sunstrike(Character character) {
        System.out.println("Даю санстрайк по " + StringUtils.upperCase(character.name));
        character.hp-=100;
    }
}
