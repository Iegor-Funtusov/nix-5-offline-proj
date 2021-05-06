public abstract class AbstractPiece {
	boolean isWhite;

	public AbstractPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public abstract void draw();

	public abstract boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol);

	public abstract int relativeValue();
}
