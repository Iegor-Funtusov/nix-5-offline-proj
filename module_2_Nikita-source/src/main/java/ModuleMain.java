import java.io.IOException;

public class ModuleMain {
    public static void main(String[] args) {
        try {
            WorkWithDates.dateMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
