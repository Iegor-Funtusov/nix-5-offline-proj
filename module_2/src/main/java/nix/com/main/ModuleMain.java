package nix.com.main;

import nix.com.date_parse.DateParser;
import nix.com.unique_name.UniqueName;

public class ModuleMain {
    public static void main(String[] args) {
        System.out.println(new UniqueName().readFromFile());
    }
}
