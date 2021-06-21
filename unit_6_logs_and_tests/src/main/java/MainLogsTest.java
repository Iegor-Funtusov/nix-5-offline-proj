import java.io.IOException;

public class MainLogsTest {
    public static void main(String[] args) {
        InputHelper helper = new InputHelper();
        try {
            helper.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
