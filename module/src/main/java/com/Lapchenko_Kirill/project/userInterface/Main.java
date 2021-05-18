package com.Lapchenko_Kirill.project.userInterface;

import com.Lapchenko_Kirill.project.first_level.first_task.UniqueNumbers;
import com.Lapchenko_Kirill.project.first_level.second_task.ChessBoard;
import com.Lapchenko_Kirill.project.first_level.second_task.ChessGame;
import com.Lapchenko_Kirill.project.first_level.second_task.ChessUI;
import com.Lapchenko_Kirill.project.first_level.third_task.Triangle;
import com.Lapchenko_Kirill.project.second_level.Balancer;
import com.Lapchenko_Kirill.project.third_level.LifeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void printLevel() {
        System.out.println("Which level do you want to choose 1-3? Or type in 4 to exit");
    }

    public void printFirstLevelTasks() {
        System.out.println("1 - To open UniqueNumbers task\n" +
                "2 - To open Chess task\n" +
                "3 - To open Triangle area task\n" );
    }

    public void printSecondLevelTask() {
        System.out.println("1 - To open brackets balancer");
    }

    public void printThirdLevelTasks() {
        System.out.println("1 - To open life game");
    }

    private String getUserInput(String regex) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        if (userInput.matches(regex)) {
            return userInput;
        } else {
            System.out.printf("Wrong input try again!");
            return getUserInput(regex);
        }
    }

    public void callRightTask() throws IOException {
        while (true) {
            printLevel();
            int taskLevel = Integer.parseInt(getUserInput("[1-4]"));
            if (taskLevel == 1) {
                printFirstLevelTasks();
                int firstTaskLevel = Integer.parseInt(getUserInput("[1-3]"));
                switch (firstTaskLevel) {
                    case 1:
                        uniqueNumTask();
                        break;
                    case 2:
                        chessTask();
                        break;
                    case 3:
                        triangleTask();
                        break;
                }
            }
            if (taskLevel == 2) {
                bracketsBalancerTask();
            }
            if (taskLevel == 3) {
                lifeGameTask();
            }

            if(taskLevel == 4)
                break;
        }
    }

    private void uniqueNumTask() throws IOException {
        UniqueNumbers u = new UniqueNumbers();
        System.out.println("You are at unique numbers task. Type in 1 - generate array, 2 - to fill array");
        int userInput = Integer.parseInt(getUserInput("[1-2]"));
        if(userInput == 1)
            System.out.println("Number of unique nums: " + u.countUniqueNumbers(u.generateRandom()));
        if(userInput == 2)
            System.out.println("Number of unique nums: " + u.countUniqueNumbers(u.askUserFillArray()));
    }

    private void chessTask() throws IOException {
        ChessGame c = new ChessGame();
        System.out.println("You are at chess task. Please make move");
        c.play();
    }

    private void triangleTask() throws IOException {
        Triangle t = new Triangle();
        System.out.println("You are at unique numbers task. Type in 1 - generate coordinates, 2 - to fill in coordinates");
        int userInput = Integer.parseInt(getUserInput("[1-2]"));
        if(userInput == 1)
            t.GenerateRandomCoordinates();
        if(userInput == 2)
            t.askUserForCoordinates();
    }

    private void bracketsBalancerTask() throws IOException {
        Balancer b = new Balancer();
        System.out.println("You are at brackets balancer task.");
        b.isBalanced(b.getUserInput());
    }

    private void lifeGameTask() throws IOException {
        LifeGame l = new LifeGame();
        System.out.println("You are at life game task. Type in 1 - to generate field, 2 - to fill in");
        int userInput = Integer.parseInt(getUserInput("[1-2]"));
        if (userInput == 1) {
            l.fillFieldRand();
            l.nextGeneration();
            System.out.println("Next generation:");
            l.printField();
        }
        if(userInput == 2) {
            l.askUserFillField();
            l.nextGeneration();
            System.out.println("Next generation:");
            l.printField();
        }

    }
}
