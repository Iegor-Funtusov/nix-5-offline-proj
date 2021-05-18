package ua.com.levelone;

public class TriangleSquare {
    private Point a;
    private Point b;
    private Point c;

    public TriangleSquare() {
        this.a = new Point();
        this.b = new Point();
        this.c = new Point();
    }

    public TriangleSquare(int xA, int yA, int xB, int yB, int xC, int yC) {
        this.a = new Point(xA, yA);
        this.b = new Point(xB, yB);
        this.c = new Point(xC, yC);
    }

    public double square() {
        double p = (longitude(a, b) + longitude(b, c) + longitude(a, c) / 2);
        return Math.sqrt(p * (p - longitude(a, b)) * (p - longitude(b, c)) * (p - longitude(a, c)));
    }

    public double longitude(Point xP, Point yP) {
        double x = (yP.getX() - xP.getX());
        double y = (yP.getX() - xP.getX());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public String toString() {
        return "A (" + a.x + ";" + a.y + ") " +
                "B (" + b.x + ";" + b.y + ") " +
                "C (" + c.x + ";" + c.y + ") ";
    }


    private class Point {
        private int x;
        private int y;

        Point() {
            this.x = (int) (Math.random() * 100);
            this.y = (int) (Math.random() * 100);
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
