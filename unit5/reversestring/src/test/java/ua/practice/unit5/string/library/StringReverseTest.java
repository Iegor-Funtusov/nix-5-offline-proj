package ua.practice.unit5.string.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReverseTest {

    @Test
    void reverse() {
        assertEquals("olleh", StringReverse.reverse("hello"));
    }

    @Test
    void testReverse() {
        String src = "hello world";
        String dst = "worl";
        assertEquals("hello lrowd", StringReverse.reverse(src,dst));
    }

    @Test
    void testReverse1() {
        String src = "hello world";
        assertEquals("helow olrld", StringReverse.reverse(src, 3,7));
    }

    @Test
    void testReverse2() {
        String src = "hello world";
        assertEquals("hrow olleld", StringReverse.reverse(src, 'e', 'r'));
    }
    @Test
    void testReverse3() {
        String src = "hello world";
        CharSequence charSequence = "llo wo";
        assertEquals("heow ollrld", StringReverse.reverse(src, charSequence));
    }
}