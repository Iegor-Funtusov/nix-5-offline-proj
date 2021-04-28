import org.mozilla.intl.chardet.nsDetector;
import net.minidev.json.reader.ArrayWriter;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main.main");

        FirstTestClass firstTestClass   = new FirstTestClass();
        SecondTestClass secondTestClass = new SecondTestClass();

        firstTestClass.func();
        secondTestClass.func();
    }
}