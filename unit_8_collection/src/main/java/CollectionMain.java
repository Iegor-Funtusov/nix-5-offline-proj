import java.io.IOException;

public class CollectionMain {
    public static void main(String[] args) {
        try {
            InterfaceMathSet.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
