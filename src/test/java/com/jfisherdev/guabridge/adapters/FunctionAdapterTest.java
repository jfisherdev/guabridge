package com.jfisherdev.guabridge.adapters;

import static org.junit.Assert.assertEquals;

/**
 * @author Josh Fisher
 */
public class FunctionAdapterTest {

    @org.junit.Test
    public void testToGuava() throws Exception {
        final java.util.function.Function<Object, Object> javaFunction = new JavaFunction();
        final Object input = 51;
        final com.google.common.base.Function<Object, Object> guavaFunction = FunctionAdapter.toGuava(javaFunction);
        assertEquals(javaFunction.apply(input), guavaFunction.apply(input));
    }

    @org.junit.Test
    public void testFromGuava() throws Exception {
        final com.google.common.base.Function<Object, Object> guavaFunction = new GuavaFunction();
        final Integer input = 51;
        final java.util.function.Function<Object, Object> javaFunction = FunctionAdapter.fromGuava(guavaFunction);
        assertEquals(guavaFunction.apply(input), javaFunction.apply(input));
    }

    private static class GuavaFunction implements com.google.common.base.Function<Object, Object> {

        @Override
        public Object apply(Object input) {
            return input;
        }

    }

    private static class JavaFunction implements java.util.function.Function<Object, Object> {

        @Override
        public Object apply(Object o) {
            return o;
        }

    }


}