package org.example.module2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueFinderTest {

    @Test
    void findTest() {
        UniqueFinder finder = new UniqueFinder();

        String[] input = {
                "Bob",
                "Alice",
                "Doyle",
                "Bob",
                "Charlie",
                "Alice"
        };

        String result = finder.find(input);
        assertEquals("Doyle", result);
    }
}