public class ChessBoard {
    private String[][] board = new String[8][8];

    public ChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    this.board[i][j] = "0";
                } else {
                    this.board[i][j] = "#";
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (j == 0) {
                    System.out.print(this.board.length - i + "|| ");
                }
                System.out.print(this.board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\t" + "=============================");
        System.out.println("\t" + "a" + "\t" + "b" + "\t" + "c" + "\t" + "d" + "\t" + "e" + "\t" + "f" + "\t" + "g" + "\t" + "h");
    }

    public void setCell(Coordinates coordinates, Figures figure) {
        board[coordinates.getX()][coordinates.getY()] = figureToString(figure);
    }

    private String figureToString(Figures figure) {
        switch (figure) {
            case KING:
                return "K";
            case PAWN:
                return "p";
            case ROOK:
                return "r";
            case QUEEN:
                return "Q";
            case BISHOP:
                return "b";
            case KNIGHT:
                return "k";
        }
        return "";
    }

    private void setDefaultValue(Coordinates coordinates) {
        if ((coordinates.getX() + coordinates.getY()) % 2 == 0) {
            this.board[coordinates.getX()][coordinates.getY()] = "0";
        } else {
            this.board[coordinates.getX()][coordinates.getY()] = "#";
        }
    }

    public void deleteFigure(Coordinates coordinates){
        if(this.board[coordinates.getX()][coordinates.getY()]!="0"
                && this.board[coordinates.getX()][coordinates.getY()]!="#"){
            setDefaultValue(coordinates);
        }
        else {
            System.out.println("Что-то пошло не так!!!");
        }
    }
}
