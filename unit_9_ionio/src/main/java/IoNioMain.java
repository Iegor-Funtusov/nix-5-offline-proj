import serviceclasses.UiService;

import java.io.IOException;

public class IoNioMain {
    public static void main(String[] args) {
        try {
            UiService.mainInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
