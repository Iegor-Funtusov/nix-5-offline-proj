package ua.com.alevel.charac;

import org.apache.commons.lang3.StringUtils;

public class Pudge extends Character {
    public Pudge() {
        this.setName("Pudge");
        this.setHp(700);
    }

    public void hook(Character character){
        System.out.println("Хукаю " + StringUtils.upperCase(character.getName()));
        character.setHp(character.getHp()-150);
    }
}
