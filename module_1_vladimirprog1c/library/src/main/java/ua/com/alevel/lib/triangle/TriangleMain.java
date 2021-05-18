package ua.com.alevel.lib.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class TriangleMain {
    public void start(BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("Do you prefer to enter it yourself (1) or generate it automatically (2) or go to a higher level (4) or exit (5)?");
            String currentChoice = reader.readLine();
            boolean result = currentChoice.matches("[1245]");
            if (!result) {
                continue;
            }
            String str = null;
            switch (currentChoice) {
                case ("1"): {
                    str = Input(reader);
                    break;
                }
                case ("2"): {
                    str = generate();
                    break;
                }
                case ("4"): {
                    return;
                }
                case ("5"): {
                    System.exit(0);
                }
            }
            calculateArea(str);
        }

    }
    public String generate() {
        Random random = new Random();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(50);
            builder.append(number);
            builder.append(" ");
        }

        System.out.println(builder);
        return builder.toString();
    }

    public String Input(BufferedReader reader) throws IOException {

        System.out.println("Enter three pairs of coordinates  like: x1 y1 x2 y2 x3 y3");
        String currentChoice = reader.readLine();

        return currentChoice;
    }

    public void calculateArea(String str){

        Triangle triangle = new Triangle();

        String [] strAr = str.split(" ");

        Coordinates coordinates = new Coordinates(Integer.parseInt(strAr[0]),Integer.parseInt(strAr[1]));
        triangle.setA(coordinates);
        coordinates = new Coordinates(Integer.parseInt(strAr[2]),Integer.parseInt(strAr[3]));
        triangle.setB(coordinates);
        coordinates = new Coordinates(Integer.parseInt(strAr[4]),Integer.parseInt(strAr[5]));
        triangle.setC(coordinates);

        System.out.println("area = "+ triangle.calculateArea());
    }
}
