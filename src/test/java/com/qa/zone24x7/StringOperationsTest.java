package com.qa.zone24x7;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class StringOperationsTest {

    private StringOperations stringOps;

    @BeforeClass
    public void setup() {
        stringOps = new StringOperations();
    }

    @Test
    public void testReverseString() {
        assertEquals(stringOps.reverseString("hello"), "olleh");
        assertEquals(stringOps.reverseString("java"), "avaj");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testReverseStringNull() {
        stringOps.reverseString(null);
    }

    @Test
    public void testIsAlphabetic() {
        assertTrue(stringOps.isAlphabetic("hello"));
        assertFalse(stringOps.isAlphabetic("hello123"));
        assertFalse(stringOps.isAlphabetic("hello!"));
    }

    @Test
    public void testCapitalizeWords() {
        assertEquals(stringOps.capitalizeWords("hello world"), "Hello World");
        assertEquals(stringOps.capitalizeWords("java programming"), "Java Programming");
    }

    @Test
    public void testRemoveWhitespace() {
        assertEquals(stringOps.removeWhitespace("hello world"), "helloworld");
        assertEquals(stringOps.removeWhitespace("java  programming"), "javaprogramming");
    }
}
