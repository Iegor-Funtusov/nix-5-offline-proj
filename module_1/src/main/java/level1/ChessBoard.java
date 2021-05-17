package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChessBoard {

    private final List<Character> coordsCharInt = new ArrayList<>();
    private final HashMap<Character, Integer> coordsCharToInt = new HashMap<>();

    public ChessBoard() {
        setCoords();
    }

    public void printChessBoard(Knight knight) {
        System.out.println("\n    A   B   C   D   E   F   G   H  ");
        for (int i = 0; i < 8; i++) {
            System.out.println("   --- --- --- --- --- --- --- --- ");
            System.out.print((i + 1) + " |");
            for (int j = 0; j < 8; j++) {
                if ((knight.getPosX()-1==j && knight.getPosY()-1==i)){
                    System.out.print(" @ |");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println(" " + (i + 1));
        }
        System.out.println("   --- --- --- --- --- --- --- --- ");
        System.out.println("    A   B   C   D   E   F   G   H  ");
    }

    private void setCoords() {
        coordsCharToInt.put('A', 1); coordsCharInt.add('1');
        coordsCharToInt.put('B', 2); coordsCharInt.add('2');
        coordsCharToInt.put('C', 3); coordsCharInt.add('3');
        coordsCharToInt.put('D', 4); coordsCharInt.add('4');
        coordsCharToInt.put('E', 5); coordsCharInt.add('5');
        coordsCharToInt.put('F', 6); coordsCharInt.add('6');
        coordsCharToInt.put('G', 7); coordsCharInt.add('7');
        coordsCharToInt.put('H', 8); coordsCharInt.add('8');
    }

    public HashMap<Character, Integer> getCoordsCharToInt() {
        return coordsCharToInt;
    }

    public List<Character> getCoordsCharInt() {
        return coordsCharInt;
    }
}

