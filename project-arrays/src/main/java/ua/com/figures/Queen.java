package ua.com.figures;

import ua.com.enums.Figures;

public class Queen extends Figure{

    public Queen() {
        this.setFigure(Figures.QUEEN);
    }

    @Override
    public boolean canFigureMove(int x, int y) {
        if(x == this.getX() && y != this.getY())
            return true;

        if(x != this.getX() && y == this.getY())
            return true;

        return Math.abs(x - this.getX()) == Math.abs(y - this.getY());
    }
}
