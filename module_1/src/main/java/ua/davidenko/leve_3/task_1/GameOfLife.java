package ua.davidenko.leve_3.task_1;

import java.util.Random;

public class GameOfLife {
     static final int LIVE = 1;
     static final int DEAD = 0;
     static final int M = 5;
     static final int N = 5;

     public static void firstGeneration(int[][] field) {
        Random random = new Random();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                field[y][x] = random.nextBoolean() ? LIVE : DEAD;
            }
        }
    }

    public static int[][] nextGeneration(int[][] field) {
        int[][] newField = new int[M][N];
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                int cell = field[y][x];
                int newCell = DEAD;
                if (cell == LIVE && (lessThanTwoNeighbors(field, x, y) || moreThanThreeNeighbors(field, x, y))) {
                    newCell = DEAD;
                } else if (cell == LIVE && twoOrThreeNeighbors(field, x, y)) {
                    newCell = LIVE;
                } else if (cell == DEAD && threeNeighbors(field, x, y)) {
                    newCell = LIVE;
                }
                newField[y][x] = newCell;
            }
        }
        return newField;
    }

    public static boolean lessThanTwoNeighbors(int[][] field, int x, int y) {
        return calculateNeighborsCount(field, x, y) < 2;
    }

    public static boolean twoOrThreeNeighbors(int[][] field, int x, int y) {
        int neighborsCount = calculateNeighborsCount(field, x, y);
        return neighborsCount == 2 || neighborsCount == 3;
    }

    public static boolean moreThanThreeNeighbors(int[][] field, int x, int y) {
        return calculateNeighborsCount(field, x, y) > 3;
    }

    public static boolean threeNeighbors(int[][] field, int x, int y) {
        return calculateNeighborsCount(field, x, y) == 3;
    }

    public static int calculateNeighborsCount(int[][] field, int x, int y) {
        int neighborsCount = 0;
        if (isTopLeftLive(field, x, y)) {
            neighborsCount++;
        }
        if (isTopLive(field, x, y)) {
            neighborsCount++;
        }
        if (isTopRightLive(field, x, y)) {
            neighborsCount++;
        }
        if (isLeftLive(field, x, y)) {
            neighborsCount++;
        }
        if (isRightLive(field, x, y)) {
            neighborsCount++;
        }
        if (isBottomLeftLive(field, x, y)) {
            neighborsCount++;
        }
        if (isBottomLive(field, x, y)) {
            neighborsCount++;
        }
        if (isBottomRightLive(field, x, y)) {
            neighborsCount++;
        }
        return neighborsCount;
    }

    private static boolean isTopLeftLive(int[][] field, int x, int y) {
        try {
            return field[y + 1][x - 1] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private static boolean isTopLive(int[][] field, int x, int y) {
        try {
            return field[y + 1][x] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private static boolean isTopRightLive(int[][] field, int x, int y) {
        try {
            return field[y + 1][x + 1] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private static boolean isLeftLive(int[][] field, int x, int y) {
        try {
            return field[y][x - 1] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private static boolean isRightLive(int[][] field, int x, int y) {
        try {
            return field[y][x + 1] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private static boolean isBottomLeftLive(int[][] field, int x, int y) {
        try {
            return field[y - 1][x - 1] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private static boolean isBottomLive(int[][] field, int x, int y) {
        try {
            return field[y - 1][x] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private static boolean isBottomRightLive(int[][] field, int x, int y) {
        try {
            return field[y - 1][x + 1] == LIVE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    public static void printField(int[][] field) {
        for (int[] row : field) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
