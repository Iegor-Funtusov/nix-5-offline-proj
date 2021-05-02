public class Position {

    private final int x;
    private final int y;
    private boolean isPos;

    public Position(int x, int y, boolean isPos) {
        this.x = x;
        this.y = y;
        this.isPos = isPos;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPos() {
        return isPos;
    }

    public void setPos(boolean white) {
        isPos = white;
    }
}
