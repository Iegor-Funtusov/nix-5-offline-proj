package ua.com.nix;
import org.apache.commons.lang3.*;

public class Animal{

    public void print(){
    String s = "Hellow i am ANIMAL";
    System.out.println(s);
    s = StringUtils.upperCase(s);
    System.out.println(s);
    }
}