package Figures;

public class Elephant extends Figure {
    public void move(int hPosition, int vPosition)
    {
        checkAbstract(hPosition,vPosition);
    }

    public boolean checkFigure(int hPosition, int vPosition) {

        if (Math.max(hPosition,horizontalPosition)-Math.min(hPosition,horizontalPosition) == Math.max(vPosition,verticalPosition)-Math.min(vPosition,verticalPosition))
        {return true;}
        else
        {return false;}
    }
}
