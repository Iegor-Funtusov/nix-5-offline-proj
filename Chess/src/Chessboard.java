import java.util.Random;
import java.util.Scanner;

public class Chessboard {
	private Boolean gameRunning;
	private AbstractPiece[][] chessboard = new AbstractPiece[numOfRowsAndCols][numOfRowsAndCols];

	Scanner user_input = new Scanner(System.in);
	String move;

	private static final int numOfRowsAndCols = 8;
	private static int srcRow, srcCol, destRow, destCol;
	private static int whiteScore = 0, blackScore = 0;
	private static Boolean whitesTurnToMove;
	private static Boolean invalidMove = false;

	public Chessboard() {
		initialiseBoard(chessboard);
		gameRunning = true;
	}

	public Boolean getGameRunning() {
		return this.gameRunning;
	}

	private static void initialiseBoard(AbstractPiece[][] chessboard) {
		for (int row = 0; row < chessboard.length; row++) {
			for (int col = 0; col < chessboard[row].length; col++) {
				if (row == 0) { switch (col) {
					case 0:
						chessboard[row][col] = new Rook(false);
						break;
					case 1:
						chessboard[row][col] = new Knight(false);
						break;
					case 2:
						chessboard[row][col] = new Bishop(false);
						break;
					case 3:
						chessboard[row][col] = new Queen(false);
						break;
					case 4:
						chessboard[row][col] = new King(false);
						break;
					case 5:
						chessboard[row][col] = new Bishop(false);
						break;
					case 6:
						chessboard[row][col] = new Knight(false);
						break;
					case 7:
						chessboard[row][col] = new Rook(false);
						break;
					}
				} else if (row == 1) { chessboard[row][col] = new Pawn(false);
				} else if (row == 6) { chessboard[row][col] = new Pawn(true);
				} else if (row == 7) { switch (col) {
					case 0:
						chessboard[row][col] = new Rook(true);
						break;
					case 1:
						chessboard[row][col] = new Knight(true);
						break;
					case 2:
						chessboard[row][col] = new Bishop(true);
						break;
					case 3:
						chessboard[row][col] = new Queen(true);
						break;
					case 4:
						chessboard[row][col] = new King(true);
						break;
					case 5:
						chessboard[row][col] = new Bishop(true);
						break;
					case 6:
						chessboard[row][col] = new Knight(true);
						break;
					case 7:
						chessboard[row][col] = new Rook(true);
						break;
					}
				}
				else { chessboard[row][col] = null; }
			}
		}
		Random rand = new Random();
		whitesTurnToMove = rand.nextBoolean();
	}

	public void printBoard() {
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for (int row = 0; row < chessboard.length; row++) {
			System.out.print(8 - row + ".\t");
			for (int col = 0; col < chessboard[row].length; col++) {
				if (chessboard[row][col] != null) {
					chessboard[row][col].draw();
					System.out.print("\t");
				} else { System.out.print("\t"); }
			}
			System.out.println();
		}
	}

	private boolean moveValid() {
		if (srcRow < 0 || srcRow > 7 || srcCol < 0 || srcCol > 7 || destRow < 0 || destRow > 7 || destCol < 0 || destCol > 7) {
			System.out.println("Move is outside the board");
			return false;
		}

		if (chessboard[srcRow][srcCol] == null) {
			System.err.println("Origin is empty");
			return false;
		}

		if ((chessboard[srcRow][srcCol].isWhite && !whitesTurnToMove) || (!chessboard[srcRow][srcCol].isWhite && whitesTurnToMove)) {
			System.err.println("It's not your turn");
			return false;
		}

		if (!chessboard[srcRow][srcCol].isMoveValid(srcRow, srcCol, destRow, destCol)) {
			System.err.println("This piece doesn't move like that");
			return false;
		}

		if (chessboard[destRow][destCol] == null) { return true; }

		if (chessboard[srcRow][srcCol].isWhite && chessboard[destRow][destCol].isWhite) {
			System.err.println("White cannot land on white");
			return false;
		}

		if (!chessboard[srcRow][srcCol].isWhite && !chessboard[destRow][destCol].isWhite) {
			System.err.println("Black cannot land on black");
			return false;
		}

		return true;
	}

	private void updateScore() {
		if (chessboard[destRow][destCol] == null) { return; }
		if (whitesTurnToMove) { whiteScore += chessboard[destRow][destCol].relativeValue(); }
		else { blackScore += chessboard[destRow][destCol].relativeValue(); }
	}

	public void move() {
		System.out.println("Score: White " + whiteScore + " | " + blackScore + " Black");

		if (invalidMove) {
			System.out.println("Move is invalid. Please try again:");
			invalidMove = false;
		}

		else if (whitesTurnToMove) {
			System.out.println("White's turn to move\n" + "-------------------------------------------------------------------------------------------------");
		} else {
			System.out.println("Black's turn to move\n" + "-------------------------------------------------------------------------------------------------");
		}
		System.out.print("Enter the start and end coordinates of the movement of the shape(for example, a2 to a3): ");

		move = user_input.nextLine();

		if (move.equalsIgnoreCase("exit")) {
			gameRunning = false;
			System.out.println("Thanks for playing.");
			return;
		}

		String lowerCase = move.toLowerCase();
		String[] components = lowerCase.split(" ");

		srcRow = 7 - (components[0].charAt(1) - '1');
		srcCol = components[0].charAt(0) - 'a';
		destRow = 7 - (components[2].charAt(1) - '1');
		destCol = components[2].charAt(0) - 'a';

		if (moveValid()) {
			updateScore();
			chessboard[destRow][destCol] = chessboard[srcRow][srcCol];
			chessboard[srcRow][srcCol] = null;
			whitesTurnToMove = !whitesTurnToMove;
		} else {
			invalidMove = true;
			move();
		}
	}
}
