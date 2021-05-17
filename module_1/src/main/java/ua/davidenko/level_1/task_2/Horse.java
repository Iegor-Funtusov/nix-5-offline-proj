package ua.davidenko.level_1.task_2;

public class Horse {
    private int coordX;
    private int coordY;

    public Horse(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }


    public static boolean isInBoardBounds(int x, int y) {
        return (1 <= x && x <= 8) && (1 <= y && y <= 8);
    }

    public boolean canBeMovedTo(int coordX, int coordY) {
        if (((Math.abs(this.coordX - coordX) == 2 && Math.abs(this.coordY - coordY) == 1)
                || (Math.abs(this.coordX - coordX) == 1 && Math.abs(this.coordY - coordY) == 2))) {
            return true;
        } else
            return false;
    }

    public void moveTo(int x, int y) {
        if (isInBoardBounds(x, y) && canBeMovedTo(x, y)) {
            this.coordX = x;
            this.coordY = y;
        } else {
            System.out.println("Horse can not be moved to this location");
        }
    }
}

