package ua.com.alevel.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;

public class BusRegister {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BusDriverService driverService = new BusDriverService();

    public static void start() {
        driverService = new BusDriverService();

        try {
            System.out.println("What do you want to do:\n" +
                    "1 -> Create bus driver\n" +
                    "2 -> Update bus driver\n" +
                    "3 -> Delete bus driver\n" +
                    "4 -> Show bus drivers\n" +
                    "5 -> Show bus driver for name\n" +
                    "0 -> exit");
            String input;
            if ((input = reader.readLine()) != null) {
                do {
                    switch (input) {
                        case "1": {
                            create();
                        }
                        break;
                        case "2": {
                            update();
                        }
                        break;
                        case "3": {
                            delete();
                        }
                        break;
                        case "4": {
                            showAll();
                        }
                        break;
                        case "5": {
                            show();
                        }
                        case "0": {
                            System.exit(0);
                        }
                        default: {
                            System.out.println("Wrong input");
                        }
                        break;

                    }
                    System.out.println("What do you want to do:\n" +
                            "1 -> Create bus driver\n" +
                            "2 -> Update bus driver\n" +
                            "3 -> Delete bus driver\n" +
                            "4 -> Show bus drivers\n" +
                            "5 -> Show bus driver by name\n" +
                            "0 -> exit");
                } while ((input = reader.readLine()) != null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create() throws IOException {
        System.out.println("Input name: ");
        String name = reader.readLine();
        while (!name.matches("[a-zA-Z]+")) {
            System.out.println("Wrong input. Use letters");
            name = reader.readLine();
        }
        System.out.println("Input colour: ");
        String color = reader.readLine();
        while (!color.matches("[a-zA-Z]+")) {
            System.out.println("Wrong input. Use letters");
            color = reader.readLine();
        }
        System.out.println("Input age: ");
        try {
            int age = Integer.parseInt(reader.readLine());
            driverService.create(new BusDriver(age, name, color));
        } catch (NumberFormatException e) {
            System.out.println("Wrong input. Use numbers");
        }
    }

    public static void update() throws IOException {
        System.out.println("Input bus name, you want to update: ");
        Collection<BusDriver> list = driverService.read();
        String temp = reader.readLine();
        for (BusDriver driver : list)
            if (driver.getName().equals(temp)) {
                System.out.println("Choose the parameter to update:\n" +
                        "1 -> age\n" +
                        "2 -> name\n" +
                        "3 -> colour");
                switch (reader.readLine()) {
                    case "1":
                        System.out.println("Input new age: ");
                        try {
                            driver.setAge(Integer.parseInt(reader.readLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong input. Use numbers");
                        }
                        break;
                    case "2":
                        System.out.println("Input new name: ");
                        driver.setName(reader.readLine());
                        break;
                    case "3":
                        System.out.println("Input new bus colour:");
                        driver.setBusColor(reader.readLine());
                        break;
                    default: {
                        System.out.println("Wrong input");
                    }
                }
                driverService.update(driver);
                break;
            }
    }

    public static void delete() throws IOException {
        System.out.println("Input bus driver name, you want to delete: ");
        Collection<BusDriver> list = driverService.read();
        String value = reader.readLine();
        for (Iterator<BusDriver> iterator = list.iterator(); iterator.hasNext(); ) {
            BusDriver driver = iterator.next();
            if (driver.getName().equals(value)) {
                driverService.delete(driver.getId());
                System.out.println("You delete bus driver");
                break;
            }
        }
    }

    public static void show() throws IOException {
        System.out.println("Input bus driver name to show: ");
        Collection<BusDriver> list = driverService.read();
        String value = reader.readLine();
        for (BusDriver driver : list)
            if (driver.getName().equals(value)) {
                System.out.println(driverService.read(driver.getId()));
                break;
            }
    }

    public static void showAll() {
        Collection<BusDriver> list = driverService.read();
        for (BusDriver busDriver : list) {
            System.out.println(busDriver);
        }
    }
}
