package level1;

public class Triangle {

    private Coordinate a;
    private Coordinate b;
    private Coordinate c;

    public Triangle(Coordinate a, Coordinate b, Coordinate c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float findSquare() {
        return Math.abs((b.x-a.x)*(c.y-a.y)-(c.x-a.x)*(b.y-a.y))/2;
    }

    public static class Coordinate {

        private float x;
        private float y;

        public Coordinate(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
