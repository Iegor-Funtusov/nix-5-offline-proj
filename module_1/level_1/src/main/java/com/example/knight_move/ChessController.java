package com.example.knight_move;

import com.example.knight_move.chess_piece.ChessPiece;
import com.example.knight_move.chess_piece.Knight;

import java.io.BufferedReader;
import java.io.IOException;

public class ChessController {
    private final BufferedReader reader;

    public ChessController(BufferedReader reader){
        this.reader = reader;
    }

    public void exec(){
        try{
            ChessPiece chessPiece = new Knight();
            setStartPoint(chessPiece, reader);
            moveChessPiece(chessPiece, reader);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void setStartPoint(ChessPiece chessPiece, BufferedReader reader) throws IOException {
        System.out.println("Enter position X,Y of chess piece");
        System.out.print("Enter X: ");
        int x = Integer.parseInt(reader.readLine());
        System.out.print("Enter Y: ");
        int y = Integer.parseInt(reader.readLine());
        System.out.println("\n");
        if(chessPiece.isChessboardBound(x, y)){
            chessPiece.setPosition(x,y);
        } else {
            System.out.println("Please, enter right coordinate:X > 0, Y > 0");
            setStartPoint(chessPiece, reader);
        }
    }
    private void moveChessPiece(ChessPiece chessPiece, BufferedReader reader) throws IOException{
        System.out.println("Enter NEW position X,Y for move chess piece");
        System.out.print("Enter X: ");
        int x = Integer.parseInt(reader.readLine());
        System.out.print("Enter Y: ");
        int y = Integer.parseInt(reader.readLine());
        System.out.println("\n");
        if(chessPiece.isPossibleMove(x,y) && chessPiece.isChessboardBound(x,y)){
            chessPiece.setPosition(x,y);
            System.out.println("New position is: X - " + chessPiece.getPosX() + " Y - "+chessPiece.getPosY());
            chooseOperationAfterMove(chessPiece, reader);
        } else {
            System.out.println("Please, enter right coordinate:X > 0, Y > 0 "+
                    "\nor check possible move for your chess piece");
            chooseOperationAfterMove(chessPiece, reader);
        }
    }
    private void chooseOperationAfterMove(ChessPiece chessPiece, BufferedReader reader) throws IOException{
        System.out.println("\nChoose next operation: " +"\n1 - go to choose new chess piece"+
                "\n2 - continue move chess piece"+"\n3 - Back to Task selection"+"\n0 - exit");
        String read = reader.readLine();
        switch (read){
            case "1":
                exec();
                break;
            case "2":
                moveChessPiece(chessPiece, reader);
                break;
            case "3":
                break;
            case "0":
                System.exit(0);
                break;
        }

    }
}
