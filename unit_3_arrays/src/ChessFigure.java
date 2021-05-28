public class ChessFigure {
    private final Figures type;
    private Coordinates coordinates;
    private final boolean Color;

    public ChessFigure(Figures type, boolean color, String str) {
        this.type = type;
        this.Color = color;
        this.coordinates = stringToCoordinates(str);
    }

    public void setCoordinatesByString(String string) {
        this.coordinates = stringToCoordinates(string);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Figures getType() {
        return type;
    }

    public boolean isColor() {
        return Color;
    }

    public boolean canMove(String str) {
        Coordinates coords = stringToCoordinates(str);
        if (coords != null && !coords.equals(coordinates)) {
            switch (type) {
                case KING:
                    return moveKing(coords);
                case PAWN:
                    return movePawn(coords);
                case ROOK:
                    return moveRook(coords);
                case QUEEN:
                    return moveQueen(coords);
                case BISHOP:
                    return moveBishop(coords);
                case KNIGHT:
                    return moveKnight(coords);
            }
        } else {
            System.out.println("Повторите ввод еще раз");
            return false;
        }
        return false;
    }

    public Coordinates stringToCoordinates(String str) {
        Coordinates coords = new Coordinates();
        char[] chArr = str.toCharArray();
        if (chArr.length == 2 && chArr[0] >= 'a' && chArr[0] <= 'h' && chArr[1] >= '1' && chArr[1] <= '8') {
            coords.setY(chArr[0] - 'a');
            coords.setX('8' - chArr[1]);
            return coords;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return null;
    }

    private boolean moveKing(Coordinates coords) {
        if (Math.abs(coords.getX() - coordinates.getX()) <= 1 && Math.abs(coords.getY() - coordinates.getY()) <= 1) {
            return true;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return false;
    }

    private boolean moveQueen(Coordinates coords) {
        if (coords.getX() == coordinates.getX() || coords.getY() == coordinates.getY() ||
                Math.abs(coords.getX() - coordinates.getX()) == Math.abs(coords.getY() - coordinates.getY())) {
            return true;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return false;
    }

    private boolean movePawn(Coordinates coords) {
        if (Color && coords.getY() == coordinates.getY() && coords.getX() - coordinates.getX() == -1
                || !Color && coords.getY() == coordinates.getY() && coords.getX() - coordinates.getX() == 1) {
            return true;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return false;
    }

    private boolean moveRook(Coordinates coords) {
        if (coords.getX() == coordinates.getX() || coords.getY() == coordinates.getY()) {
            return true;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return false;
    }

    private boolean moveBishop(Coordinates coords) {
        if (Math.abs(coords.getX() - coordinates.getX()) == Math.abs(coords.getY() - coordinates.getY())) {
            return true;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return false;
    }

    private boolean moveKnight(Coordinates coords) {
        if (Math.abs(coords.getX() - coordinates.getX()) <= 2 && Math.abs(coords.getY() - coordinates.getY()) <= 2
                && Math.abs(coords.getX() - coordinates.getX()) + Math.abs(coords.getY() - coordinates.getY()) == 3) {
            return true;
        } else {
            System.out.println("Введены неправильные координаты");
        }
        return false;
    }

    @Override
    public String toString() {
        String s;
        if (Color) {
            s = "white";
        } else {
            s = "black";
        }
        return "type=" + type +
                ", " + coordinates +
                ", Color=" + s;
    }
}
