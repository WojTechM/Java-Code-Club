package com.github.wojtech.wunit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used to mark methods that will be executed as a WUnit test suite.
 *
 * @author Wojciech Makieła
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
