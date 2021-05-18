package ua.com.alevel.lib.ches;

public class Knight extends Figure {
    public void move(int hPosition, int vPosition) {
        checkAbstract(hPosition, vPosition);
    }

    public boolean checkFigure(int hPosition, int vPosition) {

        if (Math.max(hPosition, horizontalPosition) - Math.min(hPosition, horizontalPosition) == 1
                & Math.max(vPosition, verticalPosition) - Math.min(vPosition, verticalPosition) == 2
                | Math.max(hPosition, horizontalPosition) - Math.min(hPosition, horizontalPosition) == 2
                & Math.max(vPosition, verticalPosition) - Math.min(vPosition, verticalPosition) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
