public class Position {
    private int xCoordinate;
    private int yCoordinate;
    ChessFigure figure;

    public Position(int coordinateX, int coordinateY) {
        this.xCoordinate = coordinateX;
        this.yCoordinate = coordinateY;
    }

    public ChessFigure getFigure() {
        return figure;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setFigure(ChessFigure figure) {
        this.figure = figure;
    }
}
