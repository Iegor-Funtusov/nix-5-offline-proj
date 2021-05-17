package ua.davidenko.level_1.task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean continueMove = false;
        while (true) {
            if (!continueMove) {
                System.out.println("Chose Horse location on Chessboard");
                System.out.println("Enter coordinate X");
                int coordX = Integer.parseInt(br.readLine());
                System.out.println("Enter coordinate Y");
                int coordY = Integer.parseInt(br.readLine());
                Horse horse = new Horse(coordX, coordY);
                if (Horse.isInBoardBounds(coordX, coordY)) {
                    System.out.println("Horse is on Chessboard");
                    System.out.println("Location X: " + horse.getCoordX());
                    System.out.println("Location Y: " + horse.getCoordY());
                }
                System.out.println("Chose new Horse location on Chessboard");
                System.out.println("Enter NEW coordinate X");
                int newCoordX = Integer.parseInt(br.readLine());
                System.out.println("Enter NEW cordinate Y");
                int newCoordY = Integer.parseInt(br.readLine());
                horse.moveTo(newCoordX, newCoordY);
                System.out.println("Horse moved to new location:");
                System.out.println("New location X: " + horse.getCoordX());
                System.out.println("New location Y: " + horse.getCoordY());
            }
            System.out.println("Choose option:\n" +
                    "1 - new Horse start location\n2 - continue Horse move ");
            int choose = Integer.parseInt(br.readLine());
            if (choose == 1) {
                continueMove = true;
            } else {
                continueMove = false;
            }
        }
    }
}


