import dates.WorkWithDates;
import names.UniqueName;
import transport.TransportationTheoryUi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUi {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void mainInterface() throws IOException {
        String str;
        do {
            System.out.println("1 List of dates task - \"1\"");
            System.out.println("2 Unique names task - \"2\"");
            System.out.println("3 Transportation theory task \"3\"");
            System.out.println("0 Exit - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-3]")) {
                switch (str) {
                    case "1":
                        WorkWithDates.dateMain();
                        break;
                    case "2":
                        UniqueName.mainUniqueName();
                        break;
                    case "3":
                        System.out.println("This task is performed automatically!!!");
                        System.out.println("But for testing, you can change the file 'input.txt'");
                        TransportationTheoryUi.transportInterface();
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static boolean checkRegExp(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
