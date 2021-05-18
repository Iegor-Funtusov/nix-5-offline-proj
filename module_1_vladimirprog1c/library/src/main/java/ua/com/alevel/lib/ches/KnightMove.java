package ua.com.alevel.lib.ches;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class KnightMove {
    public void start(BufferedReader reader) throws IOException {

        Figure figure = new Knight();

        while (true) {
            System.out.println("Do you prefer to enter it yourself (1) or generate it automatically (2) or go to a higher level (4) or exit (5)?");
            String currentChoice = reader.readLine();
            boolean result = currentChoice.matches("[1245]");
            if (!result) {
                continue;
            }
            String coordBegin = null;
            String coordEnd = null;
            switch (currentChoice) {
                case ("1"): {
                    if (figure.getHorizontalPosition() == 9 | figure.getVerticalPosition() == 9) {
                        coordBegin = Input(reader);
                    }
                    coordEnd = Input(reader);
                    break;
                }
                case ("2"): {
                    if (figure.getHorizontalPosition() == 9 | figure.getVerticalPosition() == 9) {
                        coordBegin = generate();
                    }
                    coordEnd = generate();
                    break;
                }
                case ("4"): {
                    return;
                }
                case ("5"): {
                    System.exit(0);
                }
            }
            isMoving(coordBegin, coordEnd, figure);
        }
    }

    private void isMoving(String coordBegin, String coordEnd, Figure figure) {

        boolean isMovingCorrect;

        try {
            int[] coordinateBeg;
            if (coordBegin == null) {
                 coordinateBeg = new int[]{figure.getHorizontalPosition(), figure.getVerticalPosition()};
            } else {
                 coordinateBeg = Bord.getCoordinate(coordBegin.substring(0, 1), Integer.parseInt(coordBegin.substring(1, 2)));
            }
            int[] coordinateEnd = Bord.getCoordinate(coordEnd.substring(0, 1), Integer.parseInt(coordEnd.substring(1, 2)));

            if (figure.getHorizontalPosition() == 9 | figure.getVerticalPosition() == 9) {
                isMovingCorrect = figure.checkAbstract(coordinateBeg[0], coordinateBeg[1]);
                System.out.println("Moving " + coordBegin + " is :" + isMovingCorrect);
                if (isMovingCorrect) {
                    figure.setHorizontalPosition(coordinateBeg[0]);
                    figure.setVerticalPosition(coordinateBeg[1]);
                }
            }
            isMovingCorrect = figure.checkAbstract(coordinateEnd[0], coordinateEnd[1]);
            System.out.println("Moving " + coordEnd + " is :" + isMovingCorrect);
            if (isMovingCorrect) {
                figure.setHorizontalPosition(coordinateBeg[0]);
                figure.setVerticalPosition(coordinateBeg[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String generate() {
        Random random = new Random();

        char[] charArray = "ABCDEFGH".toCharArray();
        int randomIndex = random.nextInt(charArray.length);
        char a = charArray[randomIndex];
        int number = random.nextInt(8);
        String returnStr = Character.toString(a) + number;

        return returnStr;
    }

    private String Input(BufferedReader reader) throws IOException {

        System.out.println("Input som numbers like: \"A1,B3,D7\"");
        String currentChoice = reader.readLine();

        return currentChoice;
    }


}
