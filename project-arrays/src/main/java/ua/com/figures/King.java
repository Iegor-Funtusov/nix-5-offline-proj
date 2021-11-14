package ua.com.figures;

import ua.com.enums.Colors;
import ua.com.enums.Figures;

public class King extends Figure {

    public King() {
        this.setFigure(Figures.KING);
    }

    @Override
    public boolean canFigureMove(int x, int y) {
        if (x > (this.getX() + 1) || x < (this.getX() - 1)) {
            return false;
        }
        return y <= (this.getY() + 1) && y >= (this.getY() - 1);
    }

}
