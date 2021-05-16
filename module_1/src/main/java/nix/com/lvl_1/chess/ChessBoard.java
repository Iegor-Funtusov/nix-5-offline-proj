package nix.com.lvl_1.chess;

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

    public void drawBoard() {
        System.out.println("+++A+B+C+D+E+F+G+H++");
        int count = 0;
        for (int j = 0; j < chessBoard.length; j++) {
            count = 0;
            for (int i = 0; i < chessBoard.length; i++) {
                if (count == 0){
                    System.out.print((j + 1) + "| ");
                }
                if (count == 7)
                    System.out.println(chessBoard[i][j] + " |");
                else {
                    System.out.print(chessBoard[i][j] + " ");
                }
                count++;
            }
        }

        System.out.println("+++A+B+C+D+E+F+G+H++");
    }

    public void updateBoard(String coords) {
        char[] cord = coords.toCharArray();

        cord[0] = convertToNum(cord[0]);
        for (int i = 0; i < cord.length; i++) {
            System.out.println(cord[i]);
        }

        chessBoard[Character.getNumericValue(cord[0]) - 1][Character.getNumericValue(cord[1]) - 1] = '1';
        drawBoard();
    }

    public char convertToNum(char sym) {
        int num = -1;
        switch (sym) {
            case 'A':
                num = 1;
                break;
            case 'B':
                num = 2;
                break;
            case 'C':
                num = 3;
                break;
            case 'D':
                num = 4;
                break;
            case 'E':
                num = 5;
                break;
            case 'F':
                num = 6;
                break;
            case 'G':
                num = 7;
                break;
            case 'H':
                num = 8;
                break;
        }
        return Character.forDigit(num, 10);
    }
}
