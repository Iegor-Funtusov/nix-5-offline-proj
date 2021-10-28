package org.example.entity;

public class Solution {
    private int problemId;
    private int cost;

    public Solution(int problemId, int cost) {
        this.problemId = problemId;
        this.cost = cost;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "problemId=" + problemId +
                ", cost=" + cost +
                '}';
    }
}
