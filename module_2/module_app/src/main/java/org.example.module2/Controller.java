package org.example.module2;

import org.example.cities.CityController;
import org.example.date.DateController;
import org.example.uniq.UniqNameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void exec() {
        try {
            System.out.println("Select the task that you want to check: " + "\n 1 - Date"
                    + "\n 2 - Unique name" + "\n 3 - Cities. Shortest path" + "\n 0 - exit");
            chooseTask(reader.readLine());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            closeReader();
        }
    }

    private void chooseTask(String read) throws IOException {
        switch (read) {
            case "1": {
                dateTask();
                exec();
                break;
            }
            case "2": {
                uniqueNameTask();
                exec();
                break;
            }
            case "3": {
                citiesTask();
                exec();
                break;
            }
            case "0": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Enter correct operation!");
                exec();
            }
        }
    }

    private void dateTask() throws IOException {
        DateController controller = new DateController(reader);
        controller.dateFormat();
    }

    private void uniqueNameTask() throws IOException {
        UniqNameController controller = new UniqNameController(reader);
        controller.findUniqName();
    }

    private void citiesTask(){
        CityController controller = new CityController();
        controller.exec();
    }

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
