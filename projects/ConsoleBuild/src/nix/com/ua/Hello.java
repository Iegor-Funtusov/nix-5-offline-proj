package nix.com.ua;

import org.apache.commons.lang3.*;

import nix.com.ua.Calculate;

public class Hello {
    public static void main(String[] args) {
        String s = "Hello!";
        System.out.println(s);
        s = StringUtils.upperCase(s);
        System.out.println(s);
        Calculate calculate = new Calculate();
        PrintWorld printWorld = new PrintWorld();
        printWorld.Print();
        System.out.println(calculate.calc());
    }
}
