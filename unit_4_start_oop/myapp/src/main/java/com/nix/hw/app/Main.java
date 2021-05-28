package com.nix.hw.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static VehicleService vehicleService = new VehicleService();

    public static void main(String[] args) {

        String message = "\nChoose operation:\n\n" +
                "1 - create\n" +
                "2 - delete\n" +
                "3 - update\n" +
                "4 - read object\n" +
                "5 - read all\n" +
                "6 - exit\n" +
                "\nEnter the number: ";

        while (true) {

            int choice = correctIntInput(message);

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    readObject();
                    break;
                case 5:
                    readAll();
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }

    private static void create() {
        Vehicle vehicle = new Vehicle();
        vehicle.setEngineVolume(correctIntInput("\nCreating\nEnter engine volume: "));
        vehicleService.create(vehicle);
    }

    private static void delete() {
        vehicleService.delete(correctIdInput("\nDeleting"));
    }

    private static void update() {
        Vehicle vehicle = vehicleService.read(correctIdInput("\nUpdating"));
        vehicle.setEngineVolume(correctIntInput("\nSet engine volume: "));
        vehicleService.update(vehicle);
    }

    private static void readObject() {
        System.out.println("\n" + vehicleService.read(correctIdInput("\nReading")).toString());
    }

    private static void readAll() {
        System.out.println("\nRead all\n");
        for (Vehicle vehicle : vehicleService.read()) {
            System.out.println(vehicle);
        }
    }

    private static String correctIdInput(String message) {
        message = message + "\nEnter object's id: ";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print(message);
            try {
                String inputId = reader.readLine();
                if (vehicleService.read().stream().anyMatch(v -> v.getId().equals(inputId))) {
                    return inputId;
                }
            } catch (IOException e) {}
        }
    }

    private static int correctIntInput(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        while (true) {
            try {
                System.out.print(message);
                num = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException | NumberFormatException e) { }
        }
        return num;
    }

}
