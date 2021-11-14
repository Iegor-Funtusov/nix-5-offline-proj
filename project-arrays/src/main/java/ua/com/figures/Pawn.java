package ua.com.figures;

import ua.com.enums.Colors;
import ua.com.enums.Figures;

public class Pawn extends Figure {

    public Pawn() {
        this.setFigure(Figures.PAWN);
    }

    @Override
    public boolean canFigureMove(int x, int y) {
        if (y != this.getY())
            return false;

        if (this.getColor() == Colors.WHITE && x != (this.getX() - 1))
            return false;

        return this.getColor() != Colors.BLACK || x == (this.getX() + 1);
    }
}
