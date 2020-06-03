package com.github.wojtech.wunit;

import static com.github.wojtech.wunit.Assertions.assertEquals;

public class WUnitTest {

    @Test
    public static void testThatShouldPass() {
        assertEquals(null, null);
    }

    @Test
    public static void testThatNotShouldPass() {
        assertEquals("cokolwiek", null);
    }

    @Test
    public static void testThatNotShouldPassDueToUnexpectedException() {
        throw new NullPointerException("null was here :(");
    }

}