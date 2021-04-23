package ua.com.alevel;

import ua.com.alevel.charac.*;
import org.apache.commons.lang3.*;

public class Game {
    public static void main(String[] args) {
        Pudge pudge = new Pudge();
        Invoker invoker = new Invoker();

        pudge.hook(invoker);
        invoker.sunstrike(pudge);
    }
}
