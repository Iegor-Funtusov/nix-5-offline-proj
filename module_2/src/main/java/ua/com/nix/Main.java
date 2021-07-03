package ua.com.nix;


import ua.com.nix.tasks.task1.Dates;
import ua.com.nix.tasks.task3.Way;
import ua.com.nix.tasks.task2.Names;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String MODULE = "*********************************************** MODULE 2 ***********************************************";
        final String TASK1 = "------------------------------------------------ TASK 1 ------------------------------------------------";
        final String TASK2 = "------------------------------------------------ TASK 2 ------------------------------------------------";
        final String TASK3 = "------------------------------------------------ TASK 3 ------------------------------------------------";
        final String FINISH = "********************************************************************************************************";

        System.out.println(MODULE);
        System.out.println(TASK1);
        System.out.println("Input data - dates.txt");
        Dates dates = new Dates();
        dates.runDates();

        System.out.println(TASK2);
        Names names = new Names();
        System.out.println("Input data - names.txt");
        System.out.println("The first unique name - " + names.runSearchUniqueName());

        System.out.println(TASK3);
        Way way = new Way();
        way.runSearchProfitableWay();
        System.out.println("Input data - input.txt");
        System.out.println("Output data - output.txt");
        System.out.println(FINISH);
    }
}
