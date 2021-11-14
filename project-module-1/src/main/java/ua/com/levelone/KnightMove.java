package ua.com.levelone;

public class KnightMove {
    private int x;
    private int y;

    public boolean canFigureMove(int x, int y) {
        int xDif = Math.abs(x - this.getX());
        int yDif = Math.abs(y - this.getY());
        return (xDif == 1 && yDif == 2) || (xDif == 2 && yDif == 1);
    }

    public boolean move(int x, int y) {
        if (canFigureMove(x, y)) {
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    public void firstMove(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    private String getPlace() {
        String convertX = "";
        switch (x) {
            case 1:
                convertX = "a";
                break;
            case 2:
                convertX = "b";
                break;
            case 3:
                convertX = "c";
                break;
            case 4:
                convertX = "d";
                break;
            case 5:
                convertX = "e";
                break;
            case 6:
                convertX = "f";
                break;
            case 7:
                convertX = "g";
                break;
            case 8:
                convertX = "h";
                break;
        }
        return convertX + y;
    }

    @Override
    public String toString() {
        return "Figure: Knight" + "\nField: " + getPlace();
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
}
