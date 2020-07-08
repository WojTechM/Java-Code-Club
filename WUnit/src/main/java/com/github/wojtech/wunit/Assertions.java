package com.github.wojtech.wunit;

import java.util.Objects;

public class Assertions {

    public static void assertEquals(Object o1, Object o2){
        if (!Objects.equals(o1, o2)) {
            throw new AssertionError(String.format("Objects %s and %s are not equal", o1, o2));
        }
    }
}
