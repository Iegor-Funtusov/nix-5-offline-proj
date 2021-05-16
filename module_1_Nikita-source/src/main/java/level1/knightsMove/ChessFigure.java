package level1.knightsMove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessFigure {
    private Coordinates coordinates;

    public ChessFigure(String str) {
        this.coordinates = stringToCoordinates(str);
    }

    public void setCoordinatesByString(String string) {
        this.coordinates = stringToCoordinates(string);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean canMove(String str) {
        Coordinates coords = stringToCoordinates(str);
        if (coords != null && !coords.equals(coordinates)) {
            return moveKnight(coords);
        } else {
            System.out.println("Повторите ввод еще раз");
            return false;
        }
    }

    public Coordinates stringToCoordinates(String str) {
        Coordinates coords = new Coordinates();
        char[] chArr = str.toCharArray();
        if (checkWithRegExp(str)) {
            coords.setY(chArr[0] - 'a');
            coords.setX('8' - chArr[1]);
            return coords;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return null;
    }

    private boolean moveKnight(Coordinates coords) {
        if (Math.abs(coords.getX() - coordinates.getX()) <= 2 && Math.abs(coords.getY() - coordinates.getY()) <= 2
                && Math.abs(coords.getX() - coordinates.getX()) + Math.abs(coords.getY() - coordinates.getY()) == 3) {
            return true;
        } else {
            System.out.println("Такой ход невозможен");
        }
        return false;
    }

    public static boolean checkWithRegExp(String str) {
        Pattern p = Pattern.compile("^[a-h][1-8]$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}