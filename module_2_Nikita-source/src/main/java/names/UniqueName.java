package names;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueName {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void mainUniqueName() throws IOException {
        String str;
        System.out.println("How do you want to test the task");
        System.out.println("1 - Manually");
        System.out.println("2 - Automatically");
        str = reader.readLine();
        if (str.equals("1")) {
            System.out.println("Please enter the names");
            System.out.println("For EXIT enter \"0\"");
            List<String> names = new LinkedList<>();
            while (!str.equals("0")) {
                str = reader.readLine();
                if (!str.equals("0")) {
                    names.add(str);
                }
            }
            if (!names.isEmpty()) {
                System.out.println("The first unique name is - " + getFirstUniqueName(names));
            } else {
                System.out.println("List of names is empty");
            }
        } else if (str.equals("2")) {
            List<String> names = Arrays.asList("Edward", "Patricia", "Jack", "Jack", "Edward", "Charles", "Megan", "Charles", "Patricia");
            System.out.println(names);
            System.out.println("The first unique name is - " + getFirstUniqueName(names));
        } else {
            System.out.println("Wrong input");
        }
    }

    private static String getFirstUniqueName(List<String> names) {
        String uniqueName = "";
        for (int i = 0; i < names.size(); i++) {
            uniqueName = names.get(i);
            names.set(i, null);
            if (!names.contains(uniqueName)) {
                return uniqueName;
            }
            names.set(i, uniqueName);
        }
        return "No unique names!!!";
    }
}
