package com.example.areas;

public class Triangle implements Shape{
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return Math.abs((a.getX()*(b.getY()-c.getY())+
                b.getX()*(c.getY()-a.getY())+
                c.getX()*(a.getY()-b.getY()))
                /2);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public String toString(){
        return"Triangle - A: " + a +
                " B: " + b +
                " C: " + c;
    }
}
