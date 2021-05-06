public class Queen extends AbstractPiece {
	public Queen(boolean isWhite) { super(isWhite); }

	@Override
	public void draw() {
		if (isWhite){ System.out.print("\u2655"); }
		else{ System.out.print("\u265B"); }
	}

	private static Boolean diagonalPath(int srcRow, int srcCol, int destRow, int destCol) {
		return ((Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol))); }

	private static Boolean straightPath(int srcRow, int srcCol, int destRow, int destCol) {
		return !((srcRow != destRow) && (srcCol != destCol)); }

	@Override
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
		return (diagonalPath(srcRow, srcCol, destRow, destCol)) || straightPath(srcRow, srcCol, destRow, destCol); }

	@Override
	public int relativeValue() { return 9; }
}
