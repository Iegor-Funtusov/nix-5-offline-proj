package ua.com.nix.task1;


import java.util.ArrayList;
import java.util.List;

public class RunDateTask {

    public void run() {
        System.out.println("-------------WELCOME TO THE TASK 1 - DATES-------------");

        List<Date> outPutStrings = new ArrayList<>();
        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("2020/04/05");
        inputStrings.add("13/11/2020");
        inputStrings.add("09-10-2020");
        inputStrings.add("05/04/2020");

        for (String iterations : inputStrings) {
            String[] date = DateUtil.parseDate(iterations);
            outPutStrings.add(new Date(date[0], date[1], date[2]));

        }

        System.out.println("-------------The result of program-------------");
        System.out.println("Input strings: ");
        for (String inputString : inputStrings) {
            System.out.println(inputString);
        }

        System.out.println("Output strings: ");
        for (Date outPutString : outPutStrings) {
            System.out.println(outPutString);
        }

        System.out.println("-------------Task 1 has ended-------------");
    }
}
