package org.example.module2;

import org.example.module2.task3.CitiesParser;
import org.example.module2.task3.GraphUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void calculateDistanceTest() {
        int[][] graph = {
                {0, 10, 20, 0, 0, 0},
                {10, 0, 0, 50, 10, 0},
                {20, 0, 0, 20, 33, 0},
                {0, 50, 20, 0, 20, 2},
                {0, 10, 33, 20, 0, 1},
                {0, 0, 0, 2, 1, 0}};

        int[] distances = GraphUtils.calculateDistance(graph, 0);

        assertArrayEquals(new int[]{0, 10, 20, 23, 20, 21}, distances);
    }

    @Test
    void parserTest() throws IOException {
        Files.deleteIfExists(Path.of("output.txt"));

        CitiesParser citiesParser = new CitiesParser();
        citiesParser.parseAndOutputResult("input.txt", "output.txt");

        assertTrue(Files.exists(Path.of("output.txt")));
    }
}