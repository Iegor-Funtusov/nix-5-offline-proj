package ua.com.alevel.lvl1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HorseMove {
    private static char[] length = new char[] {'A','B','C','D', 'E', 'F','J','H'};
    private static int[] height = new int[]{1,2,3,4,5,6,7,8};
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void horseMove() throws IOException{
        while (true) {
            System.out.println("Enter current coordinates like A5, H8 etc.");
            String firstCoord = reader.readLine();
            char[] inputCoord = firstCoord.toCharArray();
            System.out.println("Enter destination coordinates like A5, H8 etc.");
            String nextCoord = reader.readLine();
            char[] inputNext = nextCoord.toCharArray();
            if (inputCoord.length == 2 && inputNext.length == 2) {
                char x = inputCoord[0];
                int y = Character.getNumericValue(inputCoord[1]);
                char n = inputNext[0];
                int m = Character.getNumericValue(inputNext[1]);

                if ((getX(length, x) && gety(height, y)) && getX(length, n)&& gety(height, m)) {
                    if(Math.abs(numeric(x)-numeric(n)) == 2 && Math.abs(y - m) == 1 ||
                            Math.abs(numeric(x)- numeric(n) )== 1 && Math.abs(y - m )== 2){
                        System.out.println("Move is possible");
                    }
                    else {
                        System.out.println("Move is denied, try again");
                        continue;
                    }
                } else {
                    System.out.println("Invalid coordinates, try again.");
                    continue;
                }

                break;
            }
        }
    }

    public static void horseNextMove(){

    }

    public static void chessBoard() {
        //String len = length.toString();
        for (int i = length.length - 1; i >= 0; i--) {
            for (int j = 0; j < length.length; j++) {
                System.out.print(new StringBuilder().append(length[j]).append(i + 1).append(" ").toString());
            }
            System.out.println();
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

    private static int numeric(char a){
        int count = 0;
        if (a == 'A') count = 1;
        if (a == 'B') count = 2;
        if (a == 'C') count = 3;
        if (a == 'D') count = 4;
        if (a == 'E') count = 5;
        if (a == 'F') count = 6;
        if (a == 'J') count = 7;
        if (a == 'H') count = 8;
        return count;
    }
}

