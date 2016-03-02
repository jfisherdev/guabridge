package com.jfisherdev.guabridge.adapters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Josh Fisher
 */
public class OptionalAdapterTest {

    @Test
    public void testToGuavaWhenValueIsPresent() throws Exception {
        final Object reference = new Object();
        final java.util.Optional<Object> javaOptional = java.util.Optional.of(reference);
        final com.google.common.base.Optional<Object> guavaOptional = OptionalAdapter.toGuava(javaOptional);

        assertEquals(com.google.common.base.Optional.of(reference), guavaOptional);
    }

    @Test
    public void testToGuavaWhenValueIsAbsent() throws Exception {
        final java.util.Optional<Object> javaOptional = java.util.Optional.empty();
        final com.google.common.base.Optional<Object> guavaOptional = OptionalAdapter.toGuava(javaOptional);

        assertEquals(com.google.common.base.Optional.absent(), guavaOptional);
    }

    @Test
    public void testFromGuavaWhenValueIsPresent() throws Exception {
        final Object reference = new Object();
        final com.google.common.base.Optional<Object> guavaOptional = com.google.common.base.Optional.of(reference);
        final java.util.Optional<Object> javaOptional = OptionalAdapter.fromGuava(guavaOptional);


        assertEquals(java.util.Optional.of(reference), javaOptional);
    }

    @Test
    public void testFromGuavaWhenValueIsAbsent() throws Exception {
        final com.google.common.base.Optional<Object> guavaOptional = com.google.common.base.Optional.absent();
        final java.util.Optional<Object> javaOptional = OptionalAdapter.fromGuava(guavaOptional);

        assertEquals(java.util.Optional.empty(), javaOptional);
    }
}