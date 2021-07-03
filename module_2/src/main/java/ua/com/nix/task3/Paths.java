package ua.com.nix.task3;

public class Paths {

    private final int neighbor;
    private final int cost;

    public int getNeighbor() {
        return neighbor;
    }

    public int getCost() {
        return cost;
    }

    public Paths(int neighbor, int cost) {
        this.neighbor = neighbor; this.cost = cost;
    }

}
