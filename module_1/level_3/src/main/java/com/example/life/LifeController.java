package com.example.life;

import java.io.BufferedReader;
import java.io.IOException;

public class LifeController {
    private final BufferedReader reader;

    public LifeController(BufferedReader reader){
        this.reader = reader;
    }

    public void startGame() throws IOException {
        System.out.println("Game of Life MENU: " + "\n 1 - Start new game"
                + "\n 2 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                game();
                startGame();
                break;
            }
            case "2":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Enter correct operation!");
                startGame();
            }
        }
    }

    private void game() throws IOException {
        System.out.println("Enter Size of game board: ");
        System.out.println("M: ");
        int sizeM = Integer.parseInt(reader.readLine());
        System.out.println("N: ");
        int sizeN = Integer.parseInt(reader.readLine());
        GameBoard board = new GameBoard(sizeM, sizeN);
        board.printGameBoard();
        setOperationAfterStartGame(board);
    }

    private void setOperationAfterStartGame(GameBoard board) throws IOException {
        System.out.println("Game of Life MENU: " + "\n 1 - next State of game"
                + "\n 2 - Back to the game START MENU " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                nextState(board);
                setOperationAfterStartGame(board);
                break;
            }
            case "2":{
                startGame();
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Enter correct operation!");
                setOperationAfterStartGame(board);
            }
        }
    }

    private void nextState(GameBoard board){
        board.nextStateOfGameBoard();
        board.printGameBoard();
    }
}
