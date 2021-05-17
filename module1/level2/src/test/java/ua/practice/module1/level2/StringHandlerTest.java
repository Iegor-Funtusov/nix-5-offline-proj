package ua.practice.module1.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHandlerTest {

    @Test
    @DisplayName("Handle not valid string")
    void handle1() {
        StringHandler stringHandler = new StringHandler("zxc(zxc]a[sd)z");
        assertFalse(stringHandler.handle());
    }
    @Test
    @DisplayName("Handle valid string")
    void handle2() {
        StringHandler stringHandler = new StringHandler("zxc(zxc)a[sd]z");
        assertTrue(stringHandler.handle());
    }

    @Test
    @DisplayName("Handle valid string with empty content")
    void handle3() {
        StringHandler stringHandler = new StringHandler("zxc()a[]z");
        assertTrue(stringHandler.handle());
    }

    @Test
    @DisplayName("Handle valid string with 3 type of brackets")
    void handle4() {
        StringHandler stringHandler = new StringHandler("zxc(x)a[{zxc}]z");
        assertTrue(stringHandler.handle());
    }
}