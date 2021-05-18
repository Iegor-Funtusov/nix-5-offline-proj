package ua.com.levelthree;

public class GameLife {
    private final boolean[][] fields;
    private final int columns;
    private final int rows;

    public GameLife(int q) {
        columns = q;
        rows = q;
        fields = new boolean[columns][rows];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                fields[i][j] = Math.round(Math.random()) == 1;
            }
        }
    }


    public GameLife(boolean[][] field, int dimension) {
        this.columns = dimension;
        this.rows = dimension;
        this.fields = field.clone();
    }


    public void nextStep() {
        if (columns == 1 && rows == 1) {
            return;
        }

        int neighbors;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                neighbors = calculateNeighbors(i, j);
                fields[i][j] = getState(neighbors, i, j);
            }
        }
    }


    private int checkCell(int i, int j) {
        if (fields[i][j])
            return 1;
        return 0;
    }


    private boolean getState(int neighbors, int i, int j) {
        if (neighbors < 2 && fields[i][j])
            return false;
        if ((neighbors == 2 || neighbors == 3) && fields[i][j])
            return true;
        if (neighbors > 3 && fields[i][j])
            return false;
        return neighbors == 3 && !fields[i][j];
    }


    private int calculateNeighbors(int i, int j) {
        int neighbors = 0;

        if (i == 0 && j == 0) {
            neighbors += checkCell(i, j + 1);
            neighbors += checkCell(i + 1, j + 1);
            neighbors += checkCell(i + 1, j);

            return neighbors;
        }

        if (i == 0 && j == rows - 1) {
            neighbors += checkCell(i + 1, j);
            neighbors += checkCell(i + 1, j - 1);
            neighbors += checkCell(i, j - 1);

            return neighbors;
        }

        if (i == columns - 1 && j == 0) {
            neighbors += checkCell(i - 1, j);
            neighbors += checkCell(i - 1, j + 1);
            neighbors += checkCell(i, j + 1);

            return neighbors;
        }

        if (i == columns - 1 && j == rows - 1) {
            neighbors += checkCell(i, j - 1);
            neighbors += checkCell(i - 1, j - 1);
            neighbors += checkCell(i - 1, j);

            return neighbors;
        }

        if (i == 0 && j < rows - 1) {
            neighbors += checkCell(i, j + 1);
            neighbors += checkCell(i + 1, j + 1);
            neighbors += checkCell(i + 1, j);
            neighbors += checkCell(i + 1, j - 1);
            neighbors += checkCell(i, j - 1);

            return neighbors;
        }

        if (j == 0 && i != 0) {
            neighbors += checkCell(i - 1, j);
            neighbors += checkCell(i - 1, j + 1);
            neighbors += checkCell(i, j + 1);
            neighbors += checkCell(i + 1, j + 1);
            neighbors += checkCell(i + 1, j);

            return neighbors;
        }

        if (i == columns - 1 && j != rows - 1) {
            neighbors += checkCell(i, j - 1);
            neighbors += checkCell(i - 1, j - 1);
            neighbors += checkCell(i - 1, j);
            neighbors += checkCell(i - 1, j + 1);
            neighbors += checkCell(i, j + 1);

            return neighbors;
        }

        if (j == rows - 1 && i != columns - 1) {
            neighbors += checkCell(i + 1, j);
            neighbors += checkCell(i + 1, j - 1);
            neighbors += checkCell(i, j - 1);
            neighbors += checkCell(i - 1, j - 1);
            neighbors += checkCell(i - 1, j);

            return neighbors;
        }

        else {
            neighbors += checkCell(i + 1, j);
            neighbors += checkCell(i + 1, j - 1);
            neighbors += checkCell(i, j - 1);
            neighbors += checkCell(i - 1, j - 1);
            neighbors += checkCell(i - 1, j);
            neighbors += checkCell(i - 1, j + 1);
            neighbors += checkCell(i, j + 1);
            neighbors += checkCell(i + 1, j + 1);

            return neighbors;
        }
    }


    public boolean[][] getFields() {
        return fields;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
