package ua.com.alevel.charac;

import org.apache.commons.lang3.*;

public class Invoker extends Character {
    public Invoker() {
        this.name = "Invoker";

    }

    public void sunstrike(Character character) {
        System.out.println("Даю санстрайк по " + StringUtils.upperCase(character.name));
    }
}
