package com.github.wojtech.wunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class WUnit {

    public void executeTestsIn(Class<?>... classes) {
        for (Class<?> aClass : classes) {
            executeTestsIn(aClass);
        }
    }

    public void executeTestsIn(Class<?> aClass) {
        Method[] methods = aClass.getMethods();
        Arrays.stream(methods)
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .filter(method -> method.isAnnotationPresent(Test.class))
                .forEach(WUnit::executeTest);
    }

    private static void executeTest(Method method) {
        boolean passed = true;
        Throwable actualException = null;
        try {
            method.invoke(null);
        } catch (InvocationTargetException e) {
            actualException = e.getCause();
            passed = false;
        } catch (IllegalAccessException e) {
            actualException = new WUnitException("Test method could not be executed");
            passed = false;
        }
        String msg = getPassOrFailMessage(passed, actualException);
        System.out.printf("Method %s: %s\n", method.getName(), msg);
    }

    private static String getPassOrFailMessage(boolean passed, Throwable actualException) {
        return passed ? "PASS" : getFormattedFailMessage(actualException);
    }

    private static String getFormattedFailMessage(Throwable actualException) {
        return String.format("FAIL -> %s, %s, \n%s", actualException.getClass().getName(), actualException.getMessage(), Arrays.toString(actualException.getStackTrace()));
    }
}
