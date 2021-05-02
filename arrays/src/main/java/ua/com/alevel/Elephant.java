package ua.com.alevel;


public class Elephant extends AbstractPiece {
    public Elephant(boolean isWhite) {
        super(isWhite);

    }

    @Override
    public void draw() {
        if (isWhite) {
            System.out.println("\u2657");
        } else {
            System.out.println("\u265D");
        }
    }

    private static Boolean diagonalPath(int srcRow, int srcCol,
                                        int destRow, int destCol) {

        return ((Math.abs(srcRow - destRow) == Math.abs(srcCol
                - destCol)));
    }

    @Override
    public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
        return diagonalPath(srcRow, srcCol, destRow, destCol);
    }

    @Override
    public int relativeValue() {
        return 3;
    }
}
