package com.Lapchenko_Kirill.project.first_level.second_task;
import java.util.Locale;

public class ChessBoard {
    private final static String boardLetterCoordinates = "abcdefgh";
    public static int getNumericEquivalent(String letter){
        return boardLetterCoordinates.indexOf(letter.toLowerCase(Locale.ROOT)) + 1;
    }

    public static String getLetterEquivalent(int num) {
        return String.valueOf(boardLetterCoordinates.charAt(num));
    }

}
