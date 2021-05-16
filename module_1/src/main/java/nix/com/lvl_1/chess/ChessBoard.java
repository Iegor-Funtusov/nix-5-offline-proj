package nix.com.lvl_1.chess;

import java.util.Locale;

public class ChessBoard {
    char[][] chessBoard = new char[][] {
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0'}
    };

    public StringBuilder drawBoard() {
        StringBuilder board = new StringBuilder("+A+B+C+D+E+F+G+H++\n");
        System.out.println("+++A+B+C+D+E+F+G+H++");
        int count = 0;
        for (int j = 0; j < chessBoard.length; j++) {
            count = 0;
            for (char[] chars : chessBoard) {
                if (count == 0) {
                    board.append(j + 1).append("| ");
                    System.out.print((j + 1) + "| ");
                }
                if (count == 7) {
                    board.append(chars[j]).append(" \n");
                    System.out.println(chars[j] + " |");
                }
                else {
                    board.append(chars[j]).append(" ");
                    System.out.print(chars[j] + " ");
                }
                count++;
            }
        }
        board.append("+A+B+C+D+E+F+G+H++\n");
        System.out.println("+++A+B+C+D+E+F+G+H++");
        return board;
    }

    public void updateBoard(String coords) {
        for (int j = 0; j < chessBoard.length; j++) {
            for (int i = 0; i < chessBoard.length; i++) {
                chessBoard[j][i] = '0';
            }
        }
        char[] cord = coords.toUpperCase().toCharArray();

        cord[0] = convertToNum(cord[0]);
        for (int i = 0; i < cord.length; i++) {
            System.out.println(cord[i]);
        }

        chessBoard[Character.getNumericValue(cord[0]) - 1][Character.getNumericValue(cord[1]) - 1] = '1';
        drawBoard();
    }

    public char convertToNum(char sym) {
        int num = switch (sym) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            case 'D' -> 4;
            case 'E' -> 5;
            case 'F' -> 6;
            case 'G' -> 7;
            case 'H' -> 8;
            default -> -1;
        };
        return Character.forDigit(num, 10);
    }
}
