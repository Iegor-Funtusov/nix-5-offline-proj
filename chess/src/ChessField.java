public class ChessField {
    private Position[][] field = new Position[8][8];

    public ChessField() {
        crateBoard();
    }

    private void crateBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[7 - i][j] = new Position(j, i);
            }
        }
    }

    public boolean checkSpace(int xCoordinate, int yCoordinate) {
        if (!(xCoordinate <= 7 && xCoordinate >= 0 && yCoordinate <= 7 && yCoordinate >= 0)) {
            return false;
        }
        if (field[7 - yCoordinate][xCoordinate].getFigure() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fillField(int xCoordinate, int yCoordinate, ChessFigure figure) {
        if (checkSpace(xCoordinate, yCoordinate)) {
            field[7 - yCoordinate][xCoordinate].setFigure(figure);
            return true;
        } else {
            return false;
        }
    }


    public boolean isOutOfBounds(int xCoordinate, int yCoordinate) {
        if (xCoordinate <= 7 && xCoordinate >= 0 || yCoordinate <= 7 && yCoordinate >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkToMove(int xCoordinate, int yCoordinate, int tempX, int tempY) {
        if (tempX <= 7 && tempX >= 0 && tempY <= 7 && tempY >= 0) {
            ChessFigure figure = field[7 - yCoordinate][xCoordinate].getFigure();
            field[7 - tempY][tempX].setFigure(figure);
            field[7 - yCoordinate][xCoordinate].setFigure(null);
            return true;
        } else {
            return false;
        }
    }

}
