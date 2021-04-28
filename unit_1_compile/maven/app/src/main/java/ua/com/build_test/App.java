package ua.com.build_test;

import org.mozilla.intl.chardet.nsDetector;
import net.minidev.json.reader.ArrayWriter;

public class App {
    public static void main( String[] args ) {
        System.out.println("App.main");

        FirstTestClass firstTestClass = new FirstTestClass();
        SecondTestClass secondTestClass = new SecondTestClass();

        firstTestClass.func();
        secondTestClass.func();


    }
}
