package ua.com.figures;

import ua.com.enums.Figures;

public class Bishop extends Figure {

    public Bishop() {
        this.setFigure(Figures.BISHOP);
    }

    @Override
    public boolean canFigureMove(int x, int y) {
        return Math.abs(x - this.getX()) == Math.abs(y - this.getY());
    }
}
