package com.jfisherdev.guabridge.adapters;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * @author Josh Fisher
 */
public class PredicateAdapterTest {

    @Test
    public void testToGuava() throws Exception {
        final java.util.function.Predicate<Object> javaPredicate = new JavaPredicate();
        final com.google.common.base.Predicate<Object> guavaPredicate = PredicateAdapter.toGuava(javaPredicate);
        final Object input = new Object();

        assertEquals(javaPredicate.test(input), guavaPredicate.apply(input));
    }

    @Test
    public void testFromGuava() throws Exception {
        final com.google.common.base.Predicate<Object> guavaPredicate = new GuavaPredicate();
        final java.util.function.Predicate<Object> javaPredicate = PredicateAdapter.fromGuava(guavaPredicate);
        final Object input = new Object();

        assertEquals(guavaPredicate.apply(input), javaPredicate.test(input));
    }

    private static class GuavaPredicate implements com.google.common.base.Predicate<Object> {
        @Override
        public boolean apply(Object input) {
            return true;
        }
    }

    private static class JavaPredicate implements java.util.function.Predicate<Object> {
        @Override
        public boolean test(Object o) {
            return true;
        }
    }


}