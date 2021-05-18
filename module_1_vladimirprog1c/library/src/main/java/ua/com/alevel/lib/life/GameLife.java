package ua.com.alevel.lib.life;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

public class GameLife {
    public void start(BufferedReader reader) throws IOException {

        while (true) {
            System.out.println("Do you prefer to enter it yourself (1) or generate it automatically (2) or go to a higher level (4) or exit (5)?");
            String currentChoice = reader.readLine();
            boolean result = currentChoice.matches("[1245]");
            if (!result) {
                continue;
            }
            String arStr = null;
            LifeBord bord;
            int[][] area;
            switch (currentChoice) {
                case ("1"): {
                    arStr = Input(reader);
                    continue;
                }
                case ("2"): {
                    bord = generate();
                    doLife(bord);
                    break;
                }
                case ("4"): {
                    return;
                }
                case ("5"): {
                    System.exit(0);
                }
            }

        }
    }
    public LifeBord generate() {
        Random random = new Random();
        int randomN = random.nextInt(20)+1;
        int randomM = random.nextInt(20)+1;
        LifeBord bord = new LifeBord();
        bord.setM(randomM);
        bord.setN(randomN);
        int[][] area = new int[randomN][randomM];



        for (int i = 0; i < randomN; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < randomM; j++) {

                int number = random.nextInt(2);
                area[i][j] = number;
                builder.append(number);
            }
            System.out.println(builder);
        }
        bord.setArea(area);
        return bord;
    }

    public String Input(BufferedReader reader) throws IOException {

        System.out.println("it's too long, you get tired, better generate ");
        return "";

    }

    public void doLife(LifeBord bord){


        int[][]ar = bord.getArea();



        for (int i = 0; i < bord.getM(); i++) {
            for (int j = 0; j < bord.getN(); j++) {
                int neighbour=0;
                //if (i == 0)
                //if ()
            }
        }


    }
}
