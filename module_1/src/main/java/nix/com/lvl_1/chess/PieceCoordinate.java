package nix.com.lvl_1.chess;

public class PieceCoordinate {
    public char x;
    public  int y;

    public PieceCoordinate(String coordinate) throws Exception {
        char[] pieceCoordinate = coordinate.toCharArray();

        this.x = pieceCoordinate[0];
        this.y = Character.getNumericValue(pieceCoordinate[1]);
        checkCoords(x, y);
    }

    private static void checkCoords(char x, int y) throws Exception {
        if (x < 'A' || x > 'H') {
            throw new Exception();
        }

        if (y < 1 || y > 8) {
            throw new Exception();
        }
    }
}
