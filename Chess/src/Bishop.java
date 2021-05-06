public class Bishop extends AbstractPiece {
	public Bishop(boolean isWhite) { super(isWhite); }

	@Override
	public void draw() {
		if (isWhite) { System.out.print("\u2657"); }
		else { System.out.print("\u265D"); }
	}

	private static Boolean diagonalPath(int srcRow, int srcCol, int destRow, int destCol) {
		return ((Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol)));
	}

	@Override
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
		return diagonalPath(srcRow, srcCol, destRow, destCol);
	}

	@Override
	public int relativeValue() { return 3; }
}
