import java.io.IOException;

public class ModuleMain {
    public static void main(String[] args) {
        try {
            MainUi.mainInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
