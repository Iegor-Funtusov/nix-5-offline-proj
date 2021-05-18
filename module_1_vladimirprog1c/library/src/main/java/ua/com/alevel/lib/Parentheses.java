package ua.com.alevel.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Parentheses {
    public void start(BufferedReader reader) throws IOException {

        while (true) {
            System.out.println("Do you prefer to enter it yourself (1) or generate it automatically (2) or go to a higher level (4) or exit (5)?");
            String currentChoice = reader.readLine();
            boolean result = currentChoice.matches("[1245]");
            if (!result) {
                continue;
            }
            String str = null;
            switch (currentChoice) {
                case ("1"): {
                    str = Input(reader);
                    break;
                }
                case ("2"): {
                    str = generate();
                    break;
                }
                case ("4"): {
                    return;
                }
                case ("5"): {
                    System.exit(0);
                }
            }
            boolean isCor = isStringCorrect(str);
            System.out.println("String correct is: "+ isCor);
        }


    }

    public String generate() {
        Random random = new Random();

        char[] charArray = "()[]{}".toCharArray();
        int randomLength = random.nextInt(10);
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < randomLength; i++) {
            int randomIndex = random.nextInt(charArray.length);
            char a = charArray[randomIndex];
            builder.append(a);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public String Input(BufferedReader reader) throws IOException {

        System.out.println("enter a string from brackets");
        String currentChoice = reader.readLine();

        return currentChoice;
    }

    public boolean isStringCorrect(String str) {

        StringBuilder builder = new StringBuilder();
        String previous = null;
        for (int i = 0; i < str.length(); i++) {
            String current = Character.toString(str.charAt(i));

            if (builder.length() > 0) {
                previous = Character.toString(builder.charAt(builder.length() - 1));
            } else {
                previous = "";
            }

            switch (current) {
                case ("("): {
                    builder.append("(");
                    break;
                }
                case (")"): {
                    if (previous.equals("(")) {
                        builder.deleteCharAt(builder.length() - 1);
                    }
                    else{
                        return false;
                    }
                    break;
                }
                case ("["): {
                    builder.append("[");
                    break;
                }
                case ("]"): {
                    if (previous.equals("[")) {
                        builder.deleteCharAt(builder.length() - 1);
                    }
                    else{
                        return false;
                    }
                    break;
                }
                case ("{"): {
                    builder.append("{");
                    break;
                }
                case ("}"): {
                    if (previous.equals("{")) {
                        builder.deleteCharAt(builder.length() - 1);
                    }
                    else{
                        return false;
                    }
                    break;
                }
            }
        }
        return true;

        }
    }
