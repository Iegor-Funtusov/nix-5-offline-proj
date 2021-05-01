package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Game {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean continueWithCurrentFigure = false;
        ChessFigure figure = null;
        while (true) {
            if (!continueWithCurrentFigure) {
                System.out.println("Chose figure color");
                System.out.println("1 - BLACK\n2 - WHITE");
                String color = br.readLine();
                color = FigureColor.chooseColor(color);
                System.out.println("Figure color is " + color);
                System.out.println("Chose figure type");
                System.out.println("1 - Peshka\n2 - Horse\n3 - King\n4 - Queen\n5 - Tura\n6 - Elephant");
                int type = Integer.parseInt(br.readLine());
                System.out.println("Chose figure location on Chessboard ");
                int coordX = askForCoordinate("Enter X");
                int coordY = askForCoordinate("Enter Y");
                if (ChessFigure.isInBoardBounds(coordX, coordY)) {
                    System.out.println("Figure is on Chessboard");
                }
                figure = FigureCreater.createFigure(type, color, coordX, coordY);
            }
            System.out.println("Chose new figure location on Chessboard");
            int newCoordX = askForCoordinate("Enter X");
            int newCoordY = askForCoordinate("Enter Y");
            figure.moveTo(newCoordX, newCoordY);

            System.out.println("New location X: " + figure.getX());
            System.out.println("New location Y: " + figure.getY());

            System.out.println("Continue with this figure or choose another?");
            System.out.println("1 - continue");
            System.out.println("2 - choose another figure");

            int choose = Integer.parseInt(br.readLine());
            if (choose == 1) {
                continueWithCurrentFigure = true;
            } else {
                continueWithCurrentFigure = false;
            }
        }
    }

    private static int askForCoordinate(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}




