package com.example.knight_move;

import com.example.knight_move.chess_piece.ChessPiece;
import com.example.knight_move.chess_piece.Knight;

import java.io.BufferedReader;
import java.io.IOException;

public class ChessController {
    private final BufferedReader reader;
    private final ChessPiece chessPiece;

    public ChessController(BufferedReader reader){
        this.reader = reader;
        chessPiece = new Knight();
    }

    public void exec(){
        try{
            chooseWayOfSetStartPoint();
            moveChessPiece();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void chooseWayOfSetStartPoint() throws IOException {
        System.out.println("Manual or Automatically generation start position?: " + "\n 1 - Manual"
                + "\n 2 - Automatically" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                manualSetStartPoint();
                break;
            }
            case "2":{
                automaticallySetStartPoint();
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Enter correct operation!");
                chooseWayOfSetStartPoint();
            }
        }
    }
    private void manualSetStartPoint() throws IOException {
        System.out.println("Enter position X,Y of chess piece");
        System.out.print("Enter X: ");
        int x = Integer.parseInt(reader.readLine());
        System.out.print("Enter Y: ");
        int y = Integer.parseInt(reader.readLine());
        System.out.println("\n");
        if(chessPiece.isChessboardBound(x, y)){
            chessPiece.setPosition(x,y);
            printChessboard();
        } else {
            System.out.println("Please, enter right coordinate:X/Y < 9, X/Y > 0");
            manualSetStartPoint();
        }
    }
    private void automaticallySetStartPoint(){
        int x = (int) (1+Math.random() * 8);
        int y = (int) (1+Math.random() * 8);
        System.out.println("Position is: X: "+ x +
                ", Y: " + y);
        if(chessPiece.isChessboardBound(x, y)){
            chessPiece.setPosition(x,y);
            printChessboard();
        } else {
            throw new RuntimeException("pos of knight out of bound");
        }
    }
    private void moveChessPiece() throws IOException{
        System.out.println("Enter NEW position X,Y for move chess piece");
        System.out.print("Enter X: ");
        int x = Integer.parseInt(reader.readLine());
        System.out.print("Enter Y: ");
        int y = Integer.parseInt(reader.readLine());
        System.out.println("\n");
        if(chessPiece.isPossibleMove(x,y) && chessPiece.isChessboardBound(x,y)){
            chessPiece.setPosition(x,y);
            System.out.println("New position is: X - " + chessPiece.getPosX() + " Y - "+chessPiece.getPosY());
            printChessboard();
        } else {
            System.out.println("Please, enter right coordinate:X/Y < 9, X/Y > 0"+
                    "\nor check possible move for your chess piece");
        }
        chooseOperationAfterMove();
    }
    private void chooseOperationAfterMove() throws IOException{
        System.out.println("\nChoose next operation: " +"\n1 - go to choose new chess piece"+
                "\n2 - continue move chess piece"+"\n3 - Back to Task selection"+"\n0 - exit");
        String read = reader.readLine();
        switch (read){
            case "1":
                exec();
                break;
            case "2":
                moveChessPiece();
                break;
            case "3":
                break;
            case "0":
                System.exit(0);
                break;
            default:{
                System.out.println("Enter correct operation!");
                chooseOperationAfterMove();
            }
        }
    }

    private void printChessboard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i == 0 ){
                    System.out.print(j + " ");
                } else if(j == 0) {
                    System.out.print(i);
                } else if(chessPiece.getPosY() == i && chessPiece.getPosX() == j){
                    System.out.print(" *");
                }
                else{
                    System.out.print(" 0");
                }
            }
            System.out.println();
        }
    }
}
