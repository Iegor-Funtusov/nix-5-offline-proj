package com.example.chess;

import com.example.chess.chesspiece.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessController {

    public void exec(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Choose chess piece: " + "\n 1 - King" + "\n 2 - Queen" + "\n 3 - Rook" +
                    "\n 4 - Bishop" + "\n 5 - Knight" + "\n 6 - Pawn"+ "\n 0 - exit");
            String read = reader.readLine();
            ChessPiece chessPiece = chooseChessPiece(read);
            chooseColor(chessPiece, reader);
            setStartPoint(chessPiece, reader);
            moveChessPiece(chessPiece, reader);

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private ChessPiece chooseChessPiece(String read){
        ChessPiece chessPiece = null;
        switch (read){
            case "1":
                chessPiece = new King();
                break;
            case "2":
                chessPiece = new Queen();
                break;
            case "3":
                chessPiece = new Rook();
                break;
            case "4":
                chessPiece = new Bishop();
                break;
            case "5":
                chessPiece = new Knight();
                break;
            case "6":
                chessPiece = new Pawn();
                break;
            case "0":
                System.exit(0);
                break;
        }
        return chessPiece;
    }
    private void chooseColor(ChessPiece chessPiece,BufferedReader reader) throws IOException {
        System.out.println("Choose chess color: " + "\n 1 - Black" + "\n 2 - White"+"\n0 - exit");
        String colorRead = reader.readLine();
        switch (colorRead){
            case "1":
                chessPiece.setColor(ChessColor.BLACK);
                break;
            case "2":
                chessPiece.setColor(ChessColor.WHITE);
                break;
            case "0":
                System.exit(0);
                break;
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
            System.out.println("Please, enter right coordinate:X/Y < 9, X/Y > 0");
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
            System.out.println("Please, enter right coordinate:X/Y < 9, X/Y > 0, " +
                    "or check possible move for your chess piece");
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
