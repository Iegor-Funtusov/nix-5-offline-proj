

import java.util.Objects;

public abstract class Coordinates {
    private int X;
    private int Y;

    public int getX() {
        return X;
    }
    public void setX(int x) {
        if(x < 9 && x > 0)
        X = x;
    }
    public int getY() {
        return Y;
    }
    public void setY(int y) {
        if(y < 9 && y > 0)
        Y = y;
    }
    public void setPosition(int x, int y){
        setX(x);
        setY(y);
    }
    public boolean isChessboardBound(int x, int y){
        return x < 9 && x > 0 && y < 9 && y > 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return X == that.X && Y == that.Y;
    }
    public abstract boolean PossibilityOfMove(int x, int y);

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}