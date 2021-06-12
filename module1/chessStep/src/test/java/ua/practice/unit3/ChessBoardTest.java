package ua.practice.unit3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.practice.unit3.pieces.*;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {
    ChessBoard chessBoard = new ChessBoard();

    @Test
    @DisplayName("Test if black pawn moves \"backward\"")
    void makeTurn() {
        chessBoard.setPosition(6, 0, new Pawn(COLOUR.BLACK));
        chessBoard.makeTurn(6, 0, 5, 0);
        assertTrue(chessBoard.getPosition(5, 0).getPiece() instanceof Pawn);
        assertNull(chessBoard.getPosition(6, 0).getPiece());
    }

    @Test
    @DisplayName("Test if black pawn moves \"forward\"")
    void makeTurn111() {
        chessBoard.setPosition(5, 5, new Pawn(COLOUR.WHITE));
        chessBoard.makeTurn(5, 5, 6, 5);
        assertTrue(chessBoard.getPosition(6, 5).getPiece() instanceof Pawn);
        assertNull(chessBoard.getPosition(5, 5).getPiece());
    }

    @Test
    @DisplayName("Test if Knight moves in L-shape")
    void makeTurn1() {
        chessBoard.setPosition(5, 5, new Knight());
        chessBoard.makeTurn(5, 5, 6, 7);
        assertTrue(chessBoard.getPosition(6, 7).getPiece() instanceof Knight);
        assertNull(chessBoard.getPosition(5, 5).getPiece());
    }

    @Test
    @DisplayName("Test if Rook moves in only direction")
    void makeTurn3() {
        chessBoard.setPosition(5, 5, new Rook());
        chessBoard.makeTurn(5, 5, 5, 7);
        assertTrue(chessBoard.getPosition(5, 7).getPiece() instanceof Rook);
        assertNull(chessBoard.getPosition(5, 5).getPiece());
    }

    @Test
    @DisplayName("Test if Bishop moves in cross")
    void makeTurn4() {
        chessBoard.setPosition(5, 5, new Bishop());
        chessBoard.makeTurn(5, 5, 3, 3);
        assertTrue(chessBoard.getPosition(3, 3).getPiece() instanceof Bishop);
        assertNull(chessBoard.getPosition(5, 5).getPiece());
    }

    @Test
    @DisplayName("Test if King moves in one position anywhere")
    void makeTurn5() {
        chessBoard.setPosition(5, 5, new King());
        chessBoard.makeTurn(5, 5, 5, 6);
        assertTrue(chessBoard.getPosition(5, 6).getPiece() instanceof King);
        assertNull(chessBoard.getPosition(5, 5).getPiece());
    }

    @Test
    @DisplayName("Test if Queen moves like a Bishop")
    void makeTurn6() {
        chessBoard.setPosition(5, 5, new Queen());
        chessBoard.makeTurn(5, 5, 7, 7);
        assertTrue(chessBoard.getPosition(7, 7).getPiece() instanceof Queen);
        assertNull(chessBoard.getPosition(5, 5).getPiece());
    }

    @Test
    @DisplayName("Test if Queen moves like a Rook")
    void makeTurn7() {
        chessBoard.setPosition(0, 3, new Queen());
        chessBoard.makeTurn(0, 3, 4, 3);
        assertTrue(chessBoard.getPosition(4, 3).getPiece() instanceof Queen);
        assertNull(chessBoard.getPosition(0, 3).getPiece());
    }
}