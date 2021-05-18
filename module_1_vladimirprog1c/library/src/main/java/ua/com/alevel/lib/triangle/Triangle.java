package ua.com.alevel.lib.triangle;

public class Triangle {

    private Coordinates a;
    private Coordinates b;
    private Coordinates c;

    public Coordinates getA() {
        return a;
    }

    public void setA(Coordinates a) {
        this.a = a;
    }

    public Coordinates getB() {
        return b;
    }

    public void setB(Coordinates b) {
        this.b = b;
    }

    public Coordinates getC() {
        return c;
    }

    public void setC(Coordinates c) {
        this.c = c;
    }

    public float calculateArea()
    {
        return Math.abs((b.getX()-a.getX())*(c.getY()-a.getY())-(c.getX()-a.getX())*(b.getY()-a.getY()))/2;
    }
}
