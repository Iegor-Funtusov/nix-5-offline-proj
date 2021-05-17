package ua.practice.module1.level1;

import org.junit.jupiter.api.Test;
import ua.practice.module1.level1.triangle.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

class Level1Test {

    @Test
    void findNumberOfUniqueElements() {
        assertEquals(4, Level1.findNumberOfUniqueElementsWithSet(new int[] {1, 4, 5, 1, 1, 3}));
    }
    @Test
    void findNumberOfUniqueElements1() {
        assertEquals(2, Level1.findNumberOfUniqueElementsWithSet(new int[] {2, 2, 2, 1, 1, 1}));
    }
    @Test
    void findTriangleArea() {
        Coordinate[] arrayCoordinates1 = new Coordinate[3];
        arrayCoordinates1[0] = new Coordinate(1,2);
        arrayCoordinates1[1] = new Coordinate(4,4);
        arrayCoordinates1[2] = new Coordinate(5,2);
        assertEquals(4, Math.round(Level1.findTriangleArea(arrayCoordinates1)));
    }

}