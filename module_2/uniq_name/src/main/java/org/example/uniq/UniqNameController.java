package org.example.uniq;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UniqNameController {
    private final BufferedReader reader;

    public UniqNameController(BufferedReader reader) {
        this.reader = reader;
    }

    public void findUniqName() throws IOException {
        System.out.println("Use sample or manual generation names? " + "\n 1 - Sample"
                + "\n 2 - Manual" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                List<String> sample = sampleNames();
                System.out.println("sample = " + sample);
                printUniqNames(sample);
                break;
            }
            case "2":{
                printUniqNames(manualGenerationNames());
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
                findUniqName();
            }
        }
    }
    private void printUniqNames(List<String> names){
        System.out.println("First unique name: ");
        String uniqName = StringTool.uniqueString(names);
        System.out.println(uniqName);
    }

    private List<String> sampleNames(){
        List<String> names = new ArrayList<>();
        names.add("Oleg");
        names.add("Oleg");
        names.add("Aleksandr");
        names.add("Ivan");
        names.add("Maksim");
        names.add("Ivan");
        names.add("Oksana");
        names.add("Aleksandr");
        return names;
    }

    private List<String> manualGenerationNames() throws IOException {
        List<String> names = new ArrayList<>();
        System.out.println("Enter number of names: ");
        int size = Integer.parseInt(reader.readLine());
        for (int i = 0; i < size; i++) {
            System.out.println("Enter name" + i + " :");
            String name = reader.readLine();
            names.add(name);
        }
        return names;
    }
}
