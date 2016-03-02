package com.jfisherdev.guabridge.adapters;

import static org.junit.Assert.assertEquals;

/**
 * @author Josh Fisher
 */
public class FunctionAdapterTest {

    @org.junit.Test
    public void testToGuava() throws Exception {
        final java.util.function.Function<Integer, String> javaFunction = new JavaFunction();
        final Integer input = 51;
        final String expectedOutput = String.valueOf(input);
        final com.google.common.base.Function<Integer, String> guavaFunction = FunctionAdapter.toGuava(javaFunction);
        assertEquals(expectedOutput, guavaFunction.apply(input));
    }

    @org.junit.Test
    public void testFromGuava() throws Exception {
        final com.google.common.base.Function<Integer, String> guavaFunction = new GuavaFunction();
        final Integer input = 51;
        final String expectedOutput = String.valueOf(input);
        final java.util.function.Function<Integer, String> javaFunction = FunctionAdapter.fromGuava(guavaFunction);
        assertEquals(expectedOutput, javaFunction.apply(input));
    }

    private static class GuavaFunction implements com.google.common.base.Function<Integer, String> {
        @Override
        public String apply(Integer input) {
            return String.valueOf(input);
        }
    }

    private static class JavaFunction implements java.util.function.Function<Integer, String> {
        @Override
        public String apply(Integer integer) {
            return String.valueOf(integer);
        }
    }


}