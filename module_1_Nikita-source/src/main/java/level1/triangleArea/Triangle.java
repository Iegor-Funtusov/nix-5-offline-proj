package level1.triangleArea;

public class Triangle {
    private final Point A;
    private final Point B;
    private final Point C;

    public Triangle(Point a, Point b, Point c) {
        A = a;
        B = b;
        C = c;
    }

    public float CalculateArea(){
        return Math.abs((A.getX()-C.getX())*(B.getY()-C.getY())-(B.getX()-C.getX())*(A.getY()-C.getY()))*0.5f;
    }
}
