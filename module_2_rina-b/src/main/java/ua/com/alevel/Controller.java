package ua.com.alevel;

import ua.com.alevel.date.DateFormatList;
import ua.com.alevel.name.UniqueName;
import ua.com.alevel.path.PathCost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int choice;

    public void run() throws IOException {
        System.out.println("Welcome to module_2_rina-b!");
        while (true){
            System.out.println("You can set your input in txt files"
                +"Choose whatever you want:\n" +
                "1 Convert dates to one format\n" +
                "2 Find first unique name in file\n" +
                "3 Find short path\n" +
                "0 Exit");
            String str = reader.readLine();
            str = str.replaceAll("\\D+","");
            if (!str.isBlank()){
                choice = Integer.parseInt(str);
            }else {
                System.out.println("incorrect input");
                continue;}
            switch (choice){
                case 1:
                    System.out.println("\nConvert dates to one format");
                    DateFormatList.formattedDate();
                    break;
                case 2:
                    System.out.println("\nFind first unique name in file");
                    UniqueName.firstUniqueName();
                    break;
                case 3:
                    System.out.println("\nFind short path");
                    PathCost.findPath();
                    break;
                case 0:

                    System.exit(0);
                    break;
                default:
                    continue;
            }

        }
    }
}