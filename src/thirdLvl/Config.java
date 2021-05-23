package thirdLvl;

import java.awt.*;

public class Config {
    public static final int SIZE = 20;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 30;
    public static final int SLEEPMS = 500;

    public static Color getColor(Status status) {
        switch (status) {
            default:
            case NONE:
                return Color.BLACK;
            case BORN:
                return Color.GRAY;
            case LIVE:
                return Color.WHITE;
            case DIED:
                return Color.BLUE;

        }
    }
}
