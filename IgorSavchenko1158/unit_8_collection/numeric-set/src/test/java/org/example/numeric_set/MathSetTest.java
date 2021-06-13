package org.example.numeric_set;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MathSetTest {

    static MathSet<Integer> mset;
    Integer[] array = {12, 13, 11, 15, 10, 19, 0, 8, 9, 4, 7, 20};
    Integer[] array2 = {86, 93, -11};

    @Test
    void constrTest() {
        mset = new MathSet<>(array);

        assertArrayEquals(array, mset.toArray());
    }

    @Test
    void constrTest2() {
        mset = new MathSet<>(array, array2);

        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.addAll(Arrays.asList(array2));

        Object[] merged = list.toArray();
        assertArrayEquals(merged, mset.toArray());

    }

    @Test
    void constrTest3() {
        MathSet<Integer> temp = new MathSet<>(array);

        mset = new MathSet<>(temp);

        assertArrayEquals(array, mset.toArray());
    }

    @Test
    void constrTest4() {
        MathSet<Integer> temp1 = new MathSet<>(array);
        MathSet<Integer> temp2 = new MathSet<>(array2);

        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.addAll(Arrays.asList(array2));

        Object[] merged = list.toArray();

        mset = new MathSet<>(temp1, temp2);

        assertArrayEquals(merged, mset.toArray());
    }

    @Test
    void addTest() {
        mset = new MathSet<>();
        mset.add(123);
        assertEquals(1, mset.size());

        mset.add(123);
        assertEquals(1, mset.size());

        assertEquals(123, mset.get(0));
    }

    @Test
    void addAllTest() {
        mset = new MathSet<>();
        mset.add(123, 456);
        assertEquals(2, mset.size());

        mset.add(123, 456);

        assertEquals(2, mset.size());
    }

    @Test
    void joinTest() {
        MathSet<Integer> temp = new MathSet<>(array);
        mset = new MathSet<>();
        mset.join(temp);
        assertEquals(array.length, mset.size());
    }

    @Test
    void joinAllTest() {
        MathSet<Integer> temp1 = new MathSet<>(array);
        MathSet<Integer> temp2 = new MathSet<>(array2);

        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.addAll(Arrays.asList(array2));

        Object[] merged = list.toArray();

        mset = new MathSet<>();
        mset.join(temp1, temp2);
        assertEquals(array.length + array2.length, mset.size());
    }

    @Test
    void sortTest() {
        mset = new MathSet<>(array);
        mset.sortAsc(1, 7);

        Integer[] semiSorted = Arrays.copyOf(array, array.length);
        Arrays.sort(semiSorted, 1, 8);
        assertArrayEquals(semiSorted, mset.toArray());
    }

    @Test
    void getTest() {
        mset = new MathSet<>(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], mset.get(i));
        }

        assertNull(mset.get(mset.size()));
        assertNull(mset.get(-1));
    }

    @Test
    void getMaxTest() {
        mset = new MathSet<>();
        assertNull(mset.getMax());
        mset.add(10);
        assertEquals(10, mset.getMax());

        mset = new MathSet<>(array);
        assertEquals(20, mset.getMax());
    }

    @Test
    void getMinTest() {
        mset = new MathSet<>();
        assertNull(mset.getMin());
        mset.add(10);
        assertEquals(10, mset.getMin());

        mset = new MathSet<>(array);
        assertEquals(0, mset.getMin());
    }

    @Test
    void getAverageTest() {
        mset = new MathSet<>();
        assertNull(mset.getAverage());
        mset.add(7);
        assertEquals(Double.valueOf(7), mset.getAverage());
        mset.add(11);
        assertEquals(Double.valueOf(9), mset.getAverage());
        mset.add(15);
        assertEquals(Double.valueOf(11), mset.getAverage());
        mset.add(27);
        assertEquals(Double.valueOf(15), mset.getAverage());
    }

    @Test
    void getMedianTest() {
        mset = new MathSet<>();
        assertNull(mset.getMedian());

        mset.add(10);
        assertEquals(Double.valueOf(10), mset.getMedian());
        mset.add(20);
        assertEquals(Double.valueOf(15), mset.getMedian());
        mset.add(30);
        assertEquals(Double.valueOf(20), mset.getMedian());
        mset.add(40);
        assertEquals(Double.valueOf(25), mset.getMedian());
    }

    @Test
    void squashTest() {
        mset = new MathSet<>(array);
        mset = mset.squash(0, array.length - 1);
        assertArrayEquals(array, mset.toArray());
        mset = mset.squash(0, 3);
        assertArrayEquals(new Integer[]{12, 13, 11, 15}, mset.toArray());
    }

    @Test
    void clearTest() {
        mset = new MathSet<>(array);
        assertEquals(array.length, mset.size());

        mset.clear();
        assertEquals(0, mset.size());
    }

    @Test
    void clearManyTest() {
        mset = new MathSet<>(array);
        assertEquals(array.length, mset.size());
        mset.clear(array);
        assertEquals(0, mset.size());
    }

    @Test
    void removeTest() {
        mset = new MathSet<>();
        mset.add(33);
        assertEquals(1, mset.size());
        mset.remove(33);
        assertEquals(0, mset.size());

        mset.add(array);

        mset.remove(20);
        assertEquals(7, mset.get(mset.size() - 1));
    }
}
