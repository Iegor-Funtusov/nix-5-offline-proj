package level1;

public class TriangleSquareApp {

    private static final String appName = "\nTriangle Square";
    private static Triangle triangle;

    public static void run() {
        boolean flag = true;
        while (true) {
            flag = Utils.showStartMenu(appName);
            if (!flag)
                break;
            createTriangle();
            showTriangleSquare();
        }
    }

    private static void createTriangle() {

        Utils.clearConsole();
        System.out.println(appName);

        System.out.println("\nSet coordinates\n---------------\n");
        Triangle.Coordinate a = new Triangle.Coordinate(Utils.correctFloatInput("Enter x1: "),
                                                        Utils.correctFloatInput("Enter y1: "));
        System.out.println();
        Triangle.Coordinate b = new Triangle.Coordinate(Utils.correctFloatInput("Enter x2: "),
                                                        Utils.correctFloatInput("Enter y2: "));
        System.out.println();
        Triangle.Coordinate c = new Triangle.Coordinate(Utils.correctFloatInput("Enter x3: "),
                                                        Utils.correctFloatInput("Enter y3: "));
        triangle = new Triangle(a, b, c);
    }

    private static void showTriangleSquare() {
        System.out.println("\nTriangle's square: " + triangle.findSquare());
        Utils.pressEnter();
    }

}
