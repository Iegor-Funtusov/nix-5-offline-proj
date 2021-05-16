package com.example.knight_move;

import com.example.knight_move.chess_piece.ChessPiece;
import com.example.knight_move.chess_piece.Knight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessController {
    public void exec(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
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
            chooseOperationAfterMove(chessPiece, reader);
        } else {
            System.out.println("Please, enter right coordinate:X > 0, Y > 0 "+
                    "\nor check possible move for your chess piece");
            moveChessPiece(chessPiece, reader);
        }
    }
    private void chooseOperationAfterMove(ChessPiece chessPiece, BufferedReader reader) throws IOException{
        System.out.println("Choose next operation: " +"\n1 - go to choose new chess piece"+
                "\n2 - continue move chess piece"+"\n0 - exit");
        String read = reader.readLine();
        switch (read){
            case "1":
                exec();
            case "2":
                moveChessPiece(chessPiece, reader);
            case "0":
                System.exit(0);
                break;
        }

    }
}
