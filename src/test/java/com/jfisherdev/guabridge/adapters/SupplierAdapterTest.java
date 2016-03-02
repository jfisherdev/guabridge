package com.jfisherdev.guabridge.adapters;

import com.google.common.base.Suppliers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Josh Fisher
 */
public class SupplierAdapterTest {

    @Test
    public void testToGuava() throws Exception {
        final Object reference = new Object();
        final java.util.function.Supplier<Object> javaSupplier = new JavaSupplier(reference);
        final com.google.common.base.Supplier<Object> guavaSupplier = SupplierAdapter.toGuava(javaSupplier);

        assertEquals(javaSupplier.get(), guavaSupplier.get());
    }

    @Test
    public void testFromGuava() throws Exception {
        final Object reference = new Object();
        final com.google.common.base.Supplier<Object> guavaSupplier = Suppliers.ofInstance(reference);
        final java.util.function.Supplier<Object> javaSupplier = SupplierAdapter.fromGuava(guavaSupplier);

        assertEquals(guavaSupplier.get(), javaSupplier.get());
    }


    private static class JavaSupplier implements java.util.function.Supplier<Object> {

        private final Object reference;

        private JavaSupplier(Object reference) {
            this.reference = reference;
        }

        @Override
        public Object get() {
            return reference;
        }
    }
}
