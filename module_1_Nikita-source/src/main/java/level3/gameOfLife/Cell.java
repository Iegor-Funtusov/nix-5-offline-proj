package level3.gameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Cell> neighbors;
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Cell() {
        this.status = Status.NONE;
        neighbors = new ArrayList<>();
    }

    void toPrepare() {
        int liveAround = countLiveNeighbors();
        status = status.toPrepare(liveAround);
        neighbors.clear();
    }

    void replace() {
        status = status.replace();
    }

    private int countLiveNeighbors() {
        int count = 0;
        for (Cell cell : neighbors) {
            if (cell.status.isCell()) {
                count++;
            }
        }
        return count;
    }

    public void addNear(Cell cell) {
        neighbors.add(cell);
    }
}
