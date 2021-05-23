package com.example.brackets;

import java.io.BufferedReader;
import java.io.IOException;

public class BracketsController {
    private final BufferedReader reader;

    public BracketsController(BufferedReader reader){
        this.reader = reader;
    }

    public void checkBrackets() throws IOException {
        System.out.println("Manual or Automatically generation String?: " + "\n 1 - Manual"
                + "\n 2 - Automatically" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                boolean isCorrect = StringTools.isCorrectBrackets(manualSetString());
                printResOfCheckBrackets(isCorrect);
                checkBrackets();
                break;
            }
            case "2":{
                String randomStr = automaticallySetString();
                System.out.println("String is generated: " + randomStr);
                boolean isCorrect = StringTools.isCorrectBrackets(randomStr);
                printResOfCheckBrackets(isCorrect);
                checkBrackets();
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Enter correct operation!");
                checkBrackets();
            }
        }
    }

    private String manualSetString() throws IOException {
        System.out.println("Enter string: ");
        return reader.readLine();
    }

    private String automaticallySetString() throws IOException {
        System.out.println("Enter size of String: ");
        int size = Integer.parseInt(reader.readLine());
        char[] brackets = new char[]{'(','{','[',']','}',')'};
        StringBuilder stringOfBrackets = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int indexOfBracket = (int) (Math.random()* brackets.length);
            char randomBracket = brackets[indexOfBracket];
            stringOfBrackets.append(randomBracket);
        }
        return stringOfBrackets.toString();
    }

    private void printResOfCheckBrackets(boolean isCorrect){
        if(isCorrect)
            System.out.println("Brackets is correct!");
        else
            System.out.println("Brackets is Incorrect!");
    }
}
