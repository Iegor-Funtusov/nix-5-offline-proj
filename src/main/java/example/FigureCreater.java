package example;

public class FigureCreater {

    protected static ChessFigure createFigure(int type, String color, int x, int y) {
        switch (type) {
            case 1:
                return new Peshka(color, x, y);
            case 2:
                return new Horse(color, x, y);
            case 3:
                return new King(color, x, y);
            case 4:
                return new Queen(color, x, y);
            case 5:
                return new Tura(color, x, y);
            case 6:
                return new Elephant(color, x, y);
            default:
                throw new IllegalArgumentException("Unknown figure type: " + type);
        }
    }
}


