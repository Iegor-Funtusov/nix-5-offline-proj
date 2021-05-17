package org.example.level3;

public class GameOfLife {

    private final int BOARD_SIZE = 80;
    private final char DEAD = '_';
    private final char ALIVE = '@';

    private boolean[] board;
    private boolean[] nextGenBoard;
}
