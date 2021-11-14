package ua.com.interfaces;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainUI {

    private static final BufferedReader bufferedReader;
    private static final String REGEX_NUMBERS = "^[0-3]$";

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        MainUI mainUI = new MainUI();
        mainUI.cycle();
    }
    private static void message() {
        System.out.println(
                "Choose the level:\n" +
                        "1 - The Level 1\n" +
                        "2 - The Level 2\n" +
                        "3 - The Level 3\n" +
                        "0 - Exit\n");
    }

    public void cycle(){
        message();
        switch (numberForSwitch()){
            case 1:{
                System.out.println("THE LEVEL ONE");
                LevelOneUI levelOneUI = new LevelOneUI();
                levelOneUI.cycle();
                break;
            }
            case 2:{
                System.out.println("THE LEVEL TWO");
                LevelTwoUI levelTwoUI = new LevelTwoUI();
                levelTwoUI.cycle();
                break;
            }
            case 3:{
                System.out.println("THE LEVEL THREE");
                LevelThreeUI levelThreeUI = new LevelThreeUI();
                levelThreeUI.cycle();
                break;
            }
            case 0:{
                System.exit(0);
            }
            default:{
                cycle();
            }
        }
    }

    @SneakyThrows
    private int numberForSwitch() {
        String number;
        do {
            System.out.print("Number: ");
            number = bufferedReader.readLine();
        } while (!number.matches(REGEX_NUMBERS));
        return Integer.parseInt(number);
    }
}
