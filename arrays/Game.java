
// Пунктам по факту соответствует, но не успеваю всё реализовать

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.printDesk();
        System.out.println("Choose a piece (Type p - pawn, q - queen, k - king, b - bishop, h-horse, r - rook");
        String figure = reader.readLine();
        Coordinates chessFigure = null;
        switch (figure) {
            case "p":  System.out.println("You have chosen a pawn");
                chessFigure = new Pawn();
                break;
            case "q":  System.out.println("You have chosen a queen");
                chessFigure = new Queen();
                break;
            case "k":  System.out.println("You have chosen a king");
                chessFigure = new King();
                break;
            case "b":  System.out.println("You have chosen a bishop");
                chessFigure = new Bishop();
                break;
            case "h":  System.out.println("You have chosen a horse");
                chessFigure = new Horse();
                break;
            case "r":  System.out.println("You have chosen a rook");
                chessFigure = new Rook();
                break;
            default: {
                System.out.println("This figure does not exist, please try again.");
                figure = reader.readLine();
                break;
            }
        }
        System.out.println("Choose a color (Type w or b): ");
        String color = reader.readLine();
        switch (color) {
            case "b" -> System.out.println("You have chosen a black color");
            case "w" -> System.out.println("You have chosen a white color");
            default -> {
                System.out.println("This color does not exist, please try again.");
                color = reader.readLine();
            }
        }
        System.out.println("Please enter a place of your figure: ");
        System.out.println("Enter X: ");
        int x = Integer.parseInt(reader.readLine());
        System.out.println("Enter Y: ");
        int y = Integer.parseInt(reader.readLine());
        if(chessFigure.isChessboardBound(x, y)){
            chessFigure.setPosition(x,y);
        } else {
            System.out.println("Enter correct coordinates: 0 < x,y > 9");
        }
        System.out.println("Enter destination coordinates: ");
        System.out.println("Enter X: ");
        int x1 = Integer.parseInt(reader.readLine());
        System.out.println("Enter Y: ");
        int y1 = Integer.parseInt(reader.readLine());
        if(chessFigure.isChessboardBound(x1, y1) && chessFigure.PossibilityOfMove(x1, y1)){
            chessFigure.setPosition(x1,y1);
            System.out.println("The figure has been moved.");
        } else {
            System.out.println("Enter correct coordinates: 0 < x,y > 9");
        }
        System.out.println("Choose operation: next - choose new figure, stop - stop application, move - move one more");
        String end = reader.readLine();
        switch (end){
            case "next" :
                System.out.println("Please, choose a figure: ");
            break;
            case "move" :
                System.out.println("Please enter a place of your figure: ");
                break;
            case "stop" :
                break;
        }

    }
}