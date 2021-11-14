package ua.com.figures;

import ua.com.enums.Figures;

public class Castle extends Figure {

    public Castle() {
        this.setFigure(Figures.CASTLE);
    }

    @Override
    public boolean canFigureMove(int x, int y) {
        if(x == this.getX() && y != this.getY())
            return true;

        return x != this.getX() && y == this.getY();
    }
}
