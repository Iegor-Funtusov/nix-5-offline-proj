package ua.davidenko.leve_3.task_1;

import static ua.davidenko.leve_3.task_1.GameOfLife.*;
import static ua.davidenko.leve_3.task_1.GameOfLife.printField;

public class GameCreater {

    public static void startRandomGame() {
        int[][] field = new int[M][N];
        int generationsCount = 0;
        firstGeneration(field);
        System.out.println("Generation " + generationsCount);
        generationsCount++;
        printField(field);
        for (generationsCount = 0; generationsCount < 2; generationsCount++) {
            field = nextGeneration(field);
            System.out.println("Generation " + generationsCount);
            printField(field);
        }
    }
}
