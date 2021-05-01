package example;

public abstract class ChessFigure {

    private String color;
    private int x;
    private int y;

    public ChessFigure() {
    }

    public ChessFigure(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveTo(int x, int y) {
        if (isInBoardBounds(x, y) && canBeMovedTo(x, y)) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Figure can not be moved to this place");
        }
    }

    protected abstract boolean canBeMovedTo(int x, int y);

    protected static boolean isInBoardBounds(int x, int y) {
        return (1 <= x && x <= 8) && (1 <= y && y <= 8);
    }
}




