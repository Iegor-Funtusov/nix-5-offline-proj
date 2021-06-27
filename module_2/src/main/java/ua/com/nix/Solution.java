package ua.com.nix;

import ua.com.nix.TravelingSalesmanProblem.SalesmanProblem;
import ua.com.nix.UniqNames.Uniq;
import ua.com.nix.date.ActionWithDates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainLabel:
        while (true) {
            System.out.println("""
                    Choose action:
                    1 -> TrueDates
                    2 -> UniqNames
                    3 -> SelesmanProblem
                    0 -> Exit""");
            String choice = null;
            try {
                choice = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (choice) {
                case "1": {
                    new ActionWithDates().run();
                    break;
                }
                case "2": {
                    new Uniq().run();
                    break;
                }
                case "3": {
                    try {
                        new SalesmanProblem().run();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "0": {
                    break MainLabel;
                }

            }
        }
    }
}