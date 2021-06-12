package ua.practice.module1.level1.triangle;

import org.junit.jupiter.api.Test;
import ua.practice.module1.level1.triangle.Coordinate;
import ua.practice.module1.level1.triangle.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Coordinate coordinateA = new Coordinate(1,2);
    Coordinate coordinateB = new Coordinate(4,4);
    Coordinate coordinateC = new Coordinate(5,2);
    Triangle triangle = new Triangle(coordinateA, coordinateB,coordinateC);

    @Test
    void calculatePerimeter() {
        triangle.calculatePerimeter();
        assertEquals(10, Math.round(triangle.getPerimeter()));
    }

    @Test
    void calculateArea() {
        assertEquals(4, Math.round(triangle.calculateArea()));
    }

    @Test
    void calculateSideLength() {
        double res = triangle.calculateSideLength(triangle.getA(),triangle.getB());
        assertEquals(4, Math.round(res));
    }

    @Test
    void calculateAllLengths() {
        triangle.calculateAllLengths();
        assertEquals(4, Math.round(triangle.getLengthAB()));
        assertEquals(4, Math.round(triangle.getLengthAC()));
        assertEquals(2, Math.round(triangle.getLengthBC()));
    }
}