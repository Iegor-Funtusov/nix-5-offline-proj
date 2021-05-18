package ua.com.alevel.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class UniqueArray {
    public void start(BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("Do you prefer to enter it yourself (1) or generate it automatically (2) or go to a higher level (4) or exit (5)?");
            String currentChoice = reader.readLine();
            boolean result = currentChoice.matches("[1245]");
            if (!result) {
                continue;
            }
            String arStr = null;
            switch (currentChoice) {
                case ("1"): {
                    arStr = Input(reader);
                    break;
                }
                case ("2"): {
                    arStr = generate();
                    break;
                }
                case ("4"): {
                    return;
                }
                case ("5"): {
                    System.exit(0);
                }
            }
            doSet(arStr);
        }

    }

    public String generate() {
        Random random = new Random();
        int randomLength = random.nextInt(20);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < randomLength; i++) {
            int number = random.nextInt(10);
            builder.append(number);
        }

        System.out.println(builder);
        return builder.toString();
    }

    public String Input(BufferedReader reader) throws IOException {

        System.out.println("Input som numbers like: 1328");
        String currentChoice = reader.readLine();

        return currentChoice;
    }

    public void doSet(String arStr){

        HashSet set = new HashSet();
        for (int i = 0; i < arStr.length(); i++) {
            set.add(arStr.charAt(i));
        }

        StringBuilder builder = new StringBuilder("");
        Iterator i =set.iterator();
        while (i.hasNext()){
            builder.append(i.next());
        }
        System.out.println(builder);
    }
}
