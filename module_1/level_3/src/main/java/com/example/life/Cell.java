package com.example.life;

public class Cell {
    private int currentState;
    private int countNeighbors = 0;

    public Cell() {
        this.currentState = (int) Math.round(Math.random());
    }

    public void nextState(){
        if(currentState == 1 && countNeighbors < 2){
            currentState = 0;
        } else if(currentState == 1 && countNeighbors > 3){
            currentState = 0;
        } else if(currentState == 0 && countNeighbors == 3){
            currentState = 1;
        }
    }

    public int getCurrentState(){
        return currentState;
    }

    public int getCountNeighbors() {
        return countNeighbors;
    }

    public void setCountNeighbors(int countNeighbors) {
        if(countNeighbors < 9){
            this.countNeighbors = countNeighbors;
        }
    }
    @Override
    public String toString(){
        return "("+currentState+")";
    }
}
