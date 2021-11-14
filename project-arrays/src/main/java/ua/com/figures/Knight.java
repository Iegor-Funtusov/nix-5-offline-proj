package ua.com.figures;

import ua.com.enums.Figures;

public class Knight extends Figure {

    public Knight() {
        this.setFigure(Figures.KNIGHT);
    }

    @Override
    public boolean canFigureMove(int x, int y) {
        int xDif = Math.abs(x - this.getX());
        int yDif = Math.abs(y - this.getY());
        return (xDif == 1 && yDif == 2) || (xDif == 2 && yDif == 1);
    }
}

