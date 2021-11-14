package ua.com.checkerboard;

import ua.com.enums.Colors;

public class Field {
    private Colors colors;

    public Field(Colors colors) {
        this.colors = colors;
    }

    public Colors getColor() {
        return colors;
    }

    public void setColor(Colors colors) {
        this.colors = colors;
    }
}
