package ua.com.alevel;

import ua.com.alevel.charac.Invoker;
import ua.com.alevel.charac.Pudge;

public class Game {
    public static void main(String[] args) {
        Pudge pudge = new Pudge();
        Invoker invoker = new Invoker();

        pudge.hook(invoker);
        invoker.sunstrike(pudge);
    }
}
