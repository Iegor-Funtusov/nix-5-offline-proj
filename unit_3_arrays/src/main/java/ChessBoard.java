import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChessBoard {

    private HashMap<Integer, Character> coordsIntToChar = new HashMap<>();
    private List<Character> coordsCharInt = new ArrayList<>();
    private HashMap<Character, Integer> coordsCharToInt = new HashMap<>();

    public ChessBoard() {
        setCoords();
    }

    public void printChessBoard(ChessFigure figure) {
        System.out.println("\n    A   B   C   D   E   F   G   H  ");
        for (int i = 0; i < 8; i++) {
            System.out.println("   --- --- --- --- --- --- --- --- ");
            System.out.print((i + 1) + " |");
            for (int j = 0; j < 8; j++) {
                if ((figure!=null) && (figure.getPosX()-1==j && figure.getPosY()-1==i)){
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
        coordsIntToChar.put(1, 'A'); coordsCharToInt.put('A', 1); coordsCharInt.add('1');
        coordsIntToChar.put(2, 'B'); coordsCharToInt.put('B', 2); coordsCharInt.add('2');
        coordsIntToChar.put(3, 'C'); coordsCharToInt.put('C', 3); coordsCharInt.add('3');
        coordsIntToChar.put(4, 'D'); coordsCharToInt.put('D', 4); coordsCharInt.add('4');
        coordsIntToChar.put(5, 'E'); coordsCharToInt.put('E', 5); coordsCharInt.add('5');
        coordsIntToChar.put(6, 'F'); coordsCharToInt.put('F', 6); coordsCharInt.add('6');
        coordsIntToChar.put(7, 'G'); coordsCharToInt.put('G', 7); coordsCharInt.add('7');
        coordsIntToChar.put(8, 'H'); coordsCharToInt.put('H', 8); coordsCharInt.add('8');
    }

    public HashMap<Integer, Character> getCoordsIntToChar() {
        return coordsIntToChar;
    }

    public HashMap<Character, Integer> getCoordsCharToInt() {
        return coordsCharToInt;
    }

    public List<Character> getCoordsCharInt() {
        return coordsCharInt;
    }
}
