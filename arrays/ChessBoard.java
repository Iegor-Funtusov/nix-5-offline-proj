

public class ChessBoard {
    String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public void printDesk () {
        for (int i = letter.length - 1; i >= 0; i--) {
            for (int j = 0; j < letter.length; j++) {
                System.out.print(letter[j] + (i + 1) + " ");
            }
            System.out.println();
        }
    }
}
