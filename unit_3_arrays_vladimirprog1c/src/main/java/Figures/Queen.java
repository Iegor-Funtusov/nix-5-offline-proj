package Figures;

public class Queen extends Figure {
    public void move(int hPosition, int vPosition)
    {
        checkAbstract(hPosition,vPosition);
    }

    public boolean checkFigure(int hPosition, int vPosition) {

        if (Math.max(hPosition,horizontalPosition)-Math.min(hPosition,horizontalPosition) == Math.max(vPosition,verticalPosition)-Math.min(vPosition,verticalPosition)|(hPosition == horizontalPosition | vPosition == verticalPosition ))
        {return true;}
        else
        {return false;}
    }
}
