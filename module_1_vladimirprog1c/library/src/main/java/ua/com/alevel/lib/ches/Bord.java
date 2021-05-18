package ua.com.alevel.lib.ches;

import java.util.HashMap;

public class Bord {

    private static Figure[][] bord = new Figure[8][8];
    static HashMap<String,Integer> indexPosition = new HashMap<String, Integer>();

    static {
        indexPosition.put("A",0);
        indexPosition.put("B",1);
        indexPosition.put("C",2);
        indexPosition.put("D",3);
        indexPosition.put("E",4);
        indexPosition.put("F",5);
        indexPosition.put("G",6);
        indexPosition.put("H",7);

        for (int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){

                bord[i][j]= null;
            }
        }
    }

    public static boolean setFigure(int horizontal, int vertical, Figure figure){

        if (bord[horizontal][vertical].equals(null))
        {
            bord[horizontal][vertical] =  figure;
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int[] getCoordinate(String horizontal, int vertical)throws Exception
    {
        int horInt = indexPosition.get(horizontal);
        int vertInt = vertical - 1;
        int[] coordinate = {horInt, vertInt};
        return coordinate;

    }
}

