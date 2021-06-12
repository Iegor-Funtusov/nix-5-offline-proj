package ua.practice.module1.level1.triangle;

public class Triangle {
    private Coordinate a;
    private Coordinate b;
    private Coordinate c;
    private double lengthAB;
    private double lengthAC;
    private double lengthBC;
    private double perimeter;
    private double area;


    public Triangle(Coordinate a, Coordinate b, Coordinate c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Triangle(Coordinate[] coordinates) {
        this.a = coordinates[0];
        this.b = coordinates[1];
        this.c = coordinates[2];
    }


    public void calculatePerimeter(){
        calculateAllLengths();
        perimeter = lengthAB+lengthAC+lengthBC;
    }

    public double calculateArea() {
        calculatePerimeter();
        double semiPerimeter = perimeter/2;
        area = Math.sqrt (semiPerimeter * (semiPerimeter - lengthAB) * (semiPerimeter - lengthAC) * (semiPerimeter - lengthBC));
        return area;
    }

    protected double calculateSideLength(Coordinate a, Coordinate b) {
        double lengthX = Math.pow(a.getX() - b.getX(), 2);
        double lengthY = Math.pow(a.getY() - b.getY(), 2);
        return Math.sqrt(lengthX + lengthY);
    }

    protected void calculateAllLengths() {
        lengthAB = calculateSideLength(a, b);
        lengthAC = calculateSideLength(a, c);
        lengthBC = calculateSideLength(b, c);
    }


    public Coordinate getA() {
        return a;
    }

    public void setA(Coordinate a) {
        this.a = a;
    }

    public Coordinate getB() {
        return b;
    }

    public void setB(Coordinate b) {
        this.b = b;
    }

    public Coordinate getC() {
        return c;
    }

    public void setC(Coordinate c) {
        this.c = c;
    }

    public double getLengthAB() {
        return lengthAB;
    }

    public double getLengthAC() {
        return lengthAC;
    }

    public double getLengthBC() {
        return lengthBC;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
