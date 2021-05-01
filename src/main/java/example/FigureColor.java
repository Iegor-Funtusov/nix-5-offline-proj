package example;

public class FigureColor {
    protected static String chooseColor(String color) {
        switch (color) {
            case "1":
                return "BLACK";
            case "2":
                return "WHITE";
            default:
                throw new IllegalArgumentException("No such color");
        }
    }
}
