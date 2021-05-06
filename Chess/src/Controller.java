public class Controller {
	public static void main(String[] args) {
		Chessboard myChessboard = new Chessboard();

		while (myChessboard.getGameRunning()) {
			myChessboard.printBoard();
			myChessboard.move();
		}
	}
}
