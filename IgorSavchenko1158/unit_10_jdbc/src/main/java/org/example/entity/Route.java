package org.example.entity;

public class Route {
    private int toId;
    private int fromId;
    private int cost;

    public Route(int toId, int fromId, int cost) {
        this.toId = toId;
        this.fromId = fromId;
        this.cost = cost;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Route{" +
                "toId=" + toId +
                ", fromId=" + fromId +
                ", cost=" + cost +
                '}';
    }
}
