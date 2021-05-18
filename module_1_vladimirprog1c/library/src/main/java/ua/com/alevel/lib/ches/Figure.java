package ua.com.alevel.lib.ches;

public abstract class Figure {
    protected int horizontalPosition = 9;
    protected int verticalPosition = 9;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public void setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public void setVerticalPosition(int verticalPosition) {
        this.verticalPosition = verticalPosition;
    }

    public abstract void move(int hPosition, int vPosition);

    public boolean checkAbstract(int hPosition, int vPosition)
    {

        if (hPosition<0|hPosition>7|vPosition<0|vPosition>7)
        {
            return false;
        }
        if (hPosition == horizontalPosition & vPosition == verticalPosition)
        {
            return false;
        }
        if (horizontalPosition == 9)
        {
            return true;
        }
        else
        {
            return checkFigure(hPosition,vPosition);
        }

    }

    public abstract boolean checkFigure(int hPosition, int vPosition);


}