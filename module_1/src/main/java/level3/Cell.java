package level3;

import java.util.ArrayList;

public class Cell {

    ArrayList<Cell> cellsNear;
    Status status;

    public Cell() {
        status = Status.NONE;
        cellsNear = new ArrayList<>();
    }

    void addNear(Cell cell) {
        cellsNear.add(cell);
    }

    void step1() {
        int around = countNearCells();
        status = status.step1(around);
    }

    void step2() {
        status = status.step2();
    }

    int countNearCells() {
        int count = 0;
        for (Cell cell : cellsNear) {
            if (cell.status.isCell()) {
                count++;
            }
        }
        return count;
    }

    void turn() {
        status = status.isCell() ? Status.NONE : Status.LIVE;
    }

}
