package ua.com.checkerboard;

import ua.com.enums.Colors;

public final class Checker {

    public static Field[][] fields;

    static {
        fields = new Field[8][8];
    }

    public Checker() {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                fields[x][y] = new Field(Colors.WHITE);
                if ((x + y) % 2 == 0) {
                    fields[x][y].setColor(Colors.BLACK);
                }
            }
        }
    }

    public String getField(int x, int y) {
        return fields[x-1][y-1].getColor().toString();
    }
}
