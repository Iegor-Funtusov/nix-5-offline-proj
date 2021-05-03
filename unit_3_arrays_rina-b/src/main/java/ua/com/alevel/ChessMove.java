package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChessMove {

    private static char[] length = new char[] {'A','B','C','D', 'E', 'F','J','H'};
    private static int[] height = new int[]{1,2,3,4,5,6,7,8};
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static void chessMove () throws IOException {

        while (true) {
            System.out.println("Enter coordinates like A5, H8 etc.");
            String coord = reader.readLine();
            char[] inputCoord = coord.toCharArray();
            if (inputCoord.length == 2) {
                char x = inputCoord[0];
                int y = Character.getNumericValue(inputCoord[1]);
                if (getX(length, x) && gety(height, y)){
                    System.out.println("You moved to "+ coord);
                }
                else {
                    System.out.println("Invalid coordinates, try again.");
                    continue;
                }


                break;
            }
        }
    }
    private static boolean getX (char[] length, char x){
        for (char i:length){
            if (Objects.equals(i, x)){
                return true;
            }
    }
        return false;
    }


    private static boolean gety (int[] height, int y){
        for (int i:height){
            if (Objects.equals(i, y)){
                return true;
            }

            }
        return false;
    }


    }

