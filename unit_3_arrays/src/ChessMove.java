public class ChessMove {

    public static void main(String[] args) {
        ChessFigure figure = new ChessFigure(Figures.QUEEN, true, "c5");
        ChessBoard board = new ChessBoard();
        board.addFigure(figure);
        System.out.println(board.getChessFigures().get(0).getCoordinates());
        board.moveFigure(figure,"f8");
        System.out.println(board.getChessFigures().get(0).getCoordinates());
        board.moveFigure(figure,"h6");
        System.out.println(board.getChessFigures().get(0).getCoordinates());
        ChessFigure figure2 = new ChessFigure(Figures.KING, true, "c5");
        board.addFigure(figure2);
        System.out.println(board.getChessFigures().get(1).getCoordinates());
        board.moveFigure(figure2,"c6");
        System.out.println(board.getChessFigures().get(1).getCoordinates());
        board.moveFigure(figure2,"b6");
        System.out.println(board.getChessFigures().get(1).getCoordinates());
    }
}
