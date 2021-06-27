package luiza;
import java.io.IOException;
public class MainClass {
    public static void main(String[] args) {
        try {
            Interface.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
