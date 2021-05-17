package com.example.brackets;

import java.io.BufferedReader;
import java.io.IOException;

public class BracketsController {
    private final BufferedReader reader;

    public BracketsController(BufferedReader reader){
        this.reader = reader;
    }

    public void chooseWayOfSetString() throws IOException {
        System.out.println("Manual or Automatically generation String?: " + "\n 1 - Manual"
                + "\n 2 - Automatically" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                boolean isCorrect = StringTools.isCorrectBrackets(manualSetString());
                printResOfCheckBrackets(isCorrect);
                break;
            }
            case "2":{
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
        }
    }

    private void printResOfCheckBrackets(boolean isCorrect){
        if(isCorrect)
            System.out.println("Brackets is correct!");
        else
            System.out.println("Brackets is Incorrect!");
    }

    private String manualSetString() throws IOException {
        System.out.println("Enter string: ");
        return reader.readLine();
    }
}
