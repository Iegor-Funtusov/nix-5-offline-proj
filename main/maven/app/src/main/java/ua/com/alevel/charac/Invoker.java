package ua.com.alevel.charac;

import org.apache.commons.lang3.StringUtils;


public class Invoker extends Character {
    public Invoker() {
        this.setName("Invoker");
        this.setHp(500);
    }

    public void sunstrike(Character character) {
        System.out.println("Даю санстрайк по " + StringUtils.upperCase(character.getName()));
        character.setHp(character.getHp()-100);
    }
}
