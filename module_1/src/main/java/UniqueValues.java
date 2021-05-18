import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueValues {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void uniqueValues() throws IOException {
        while (true) {
            System.out.print("1.Fill the array manually\n2.Fill the array with random numbers\nBack(9)\nExit(0)\nEnter the operation number: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        manually();
                        break;
                    case 2:
                        random();
                        break;
                    case 9:
                        Application application = new Application();
                        application.level1();
                        break;
                    default:
                        System.out.println("You entered invalid characters!");
                }
            }
            catch (NumberFormatException | IOException e) { System.out.println("You entered invalid characters!"); }
        }
    }
    public static void manually() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of elements of the array: ");
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Enter the number: ");
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Set<Integer> set = new LinkedHashSet<>();
        for (int i : array) {
            set.add(i);
        }
        System.out.println("Number of unique characters: " + set.size());
    }
    public static void random() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of elements of the array: ");
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 20) - 10);
            System.out.println(array[i]);
        }
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : array) {
            set.add(i);
        }
        System.out.println("Number of unique characters: " + set.size());
    }
}
