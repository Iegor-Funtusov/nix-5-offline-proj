package ua.com.alevel;

public class Knight extends ua.com.alevel.AbstractPiece {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void draw() {
        if (isWhite){
            System.out.print("\u2658");
        }
        else{
            System.out.print("\u265E");
        }
    }

    private static Boolean lShapedPath(int srcRow, int srcCol,
                                       int destRow, int destCol) {

        return ((Math.abs(srcRow - destRow) == 2 && Math.abs(srcCol
                - destCol) == 1)
                || (Math.abs(srcRow - destRow) == 1 && Math.abs(srcCol
                - destCol) == 2));
    }

    @Override
    public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
        return lShapedPath(srcRow, srcCol, destRow, destCol);
    }

    @Override
    public int relativeValue() {

        return 0;
    }

}