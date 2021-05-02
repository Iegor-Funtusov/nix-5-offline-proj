import Figures.*;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    public void startGame() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Figure figure = null;
        figure = getNewFigure(reader);
        moveFigure(reader, figure);
        while (true) {

            System.out.println("you can choose new figure \"1\" or move this one \"2\" or exit \"3\"");
            int strRead = 0;
            try {
                strRead = Integer.parseInt(reader.readLine());;
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (strRead){
                case 1:
                    figure = getNewFigure(reader);
                    moveFigure(reader, figure);
                    break;
                case 2:
                    moveFigure(reader, figure);
                    break;
                case 3:
                    System.exit(1);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + strRead);
            }



        }


    }

    public Figure getNewFigure(BufferedReader reader) {
        int intColor;
        int intFigure;

        Figure figure = null;

        boolean isСontinue = true;
        while (isСontinue) {


            System.out.println("choose figure: ");
            System.out.println("\"1\" - pawn;");
            System.out.println("\"2\" - king ;");
            System.out.println("\"3\" - queen ;");
            System.out.println("\"4\" - horse ;");
            System.out.println("\"5\" - elephant ;");
            System.out.println("\"6\" - tour ;");
            try {
                intFigure = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            switch (intFigure) {
                case 1:
                    figure = new Pawn();
                    break;
                case 2:
                    figure = new King();
                    break;
                case 3:
                    figure = new Queen();
                    break;
                case 4:
                    figure = new Horse();
                    break;
                case 5:
                    figure = new Elephant();
                    break;
                case 6:
                    figure = new Tour();
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + intFigure);
            }

            System.out.println("choose color: ");
            System.out.println("\"1\" - white;");
            System.out.println("\"2\" - black.");

            try {
                intColor = Integer.parseInt(reader.readLine());
                switch (intColor) {
                    case 1:
                        figure.setColor(Color.WHITE);
                    case 2:
                        figure.setColor(Color.BLACK);
                }
                return figure;
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

        }

        return figure;
    }

    public void moveFigure(BufferedReader reader, Figure figure) {
        System.out.println("choose position like: \"A1,B3,D7\"");


        try {
            String strPos = reader.readLine();

            int[] coordinate = Bord.getCoordinate(strPos.substring(0, 1), Integer.parseInt(strPos.substring(1, 2)));

            figure.move(coordinate[0], coordinate[1]);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("");
            e.printStackTrace();
        }

    }

}
