import ua.com.nix.task1.RunDateTask;
import ua.com.nix.task2.UniqueName;
import ua.com.nix.task3.PathTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModuleStarter {

    public void start() {

        System.out.println("ENTER A NUMBER OF TASK YOU WANT TO RUN:");
        System.out.println("""
                1 -> TASK 1. DATES
                2 -> TASK 2. UNIQUE NAMES.
                3 -> TASK 3. MINIMAL PATH.
                0 -> EXIT FROM APPLICATION.""");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String read;
            while ((read = reader.readLine()) != null) {
                switch (read) {
                    case "1" -> new RunDateTask().run();
                    case "2" -> new UniqueName().run();
                    case "3" -> new PathTask().run();
                    case "0" -> System.exit(0);
                    default -> throw new RuntimeException("Sorry, you have entered illegal value.");
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
