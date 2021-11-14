package ua.com.figures;

import lombok.Data;
import ua.com.enums.Colors;
import ua.com.enums.Figures;

@Data
public abstract class Figure {
    private int x;
    private int y;
    private Figures figure;
    private Colors color;

    public abstract boolean canFigureMove(int x, int y);

    public boolean move(int x, int y) {
        if (canFigureMove(x, y)) {
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    public void firstMove(int x, int y) {
        this.setX(x);
        this.setY(y);
    }


    private String getPlace() {
        String convertX = "";
        switch (x) {
            case 1:
                convertX = "a";
                break;
            case 2:
                convertX = "b";
                break;
            case 3:
                convertX = "c";
                break;
            case 4:
                convertX = "d";
                break;
            case 5:
                convertX = "e";
                break;
            case 6:
                convertX = "f";
                break;
            case 7:
                convertX = "g";
                break;
            case 8:
                convertX = "h";
                break;
        }
        return convertX + y;
    }

    @Override
    public String toString() {
        return "Figure: " + getColor() + " " + getFigure() + "\nField: " + getPlace();
    }
}
