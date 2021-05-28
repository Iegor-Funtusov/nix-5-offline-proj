package level3;

import java.awt.*;

public class Config {
    public static final int SIZE = 10;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 60;
    public static final int SIDE_PANEL_WIDTH = 80;


    public static Color getColor(Status status) {
        switch (status) {

            default:
            case NONE:
            case DEAD:
                return Color.DARK_GRAY;
            case LIVE:
            case BORN:
                return Color.CYAN;
        }
    }
}
