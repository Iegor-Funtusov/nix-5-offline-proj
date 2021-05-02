package Figures;

public class Tour extends Figure {
    public void move(int hPosition, int vPosition)
    {
        checkAbstract(hPosition,vPosition);
    }

    public boolean checkFigure(int hPosition, int vPosition) {
        if (hPosition == horizontalPosition | vPosition == verticalPosition )
        {return true;}
        else
        {return false;}
    }
}
