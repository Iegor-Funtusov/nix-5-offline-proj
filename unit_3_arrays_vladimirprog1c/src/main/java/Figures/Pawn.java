package Figures;

public class Pawn extends Figure {

    public void move(int hPosition, int vPosition)
    {
        if (checkAbstract(hPosition,vPosition)){
            horizontalPosition = hPosition;
            verticalPosition = vPosition;
        }
        else {
            System.out.println("wrong move ");
        }
    }

     public boolean checkFigure(int hPosition, int vPosition) {
        if (hPosition == horizontalPosition & (vPosition > verticalPosition & vPosition - verticalPosition < 3))
        {return true;}
        else
        {return false;}
    }

}
