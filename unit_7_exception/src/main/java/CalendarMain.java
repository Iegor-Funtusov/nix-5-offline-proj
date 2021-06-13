import java.io.IOException;

public class CalendarMain {
    public static void main(String[] args) {
        try {
            CalendarUI.mainInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

