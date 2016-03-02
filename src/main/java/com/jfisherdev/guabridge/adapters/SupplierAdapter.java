package com.jfisherdev.guabridge.adapters;

/**
 * @author Josh Fisher
 */
public final class SupplierAdapter {

    private SupplierAdapter() {
    }

    public static <T> com.google.common.base.Supplier<T> toGuava(java.util.function.Supplier<T> javaSupplier) {
        return new GuavaSupplier<>(javaSupplier);
    }

    public static <T> java.util.function.Supplier<T> fromGuava(com.google.common.base.Supplier<T> guavaSupplier) {
        return new JavaSupplier<>(guavaSupplier);
    }

    private static class GuavaSupplier<T> implements com.google.common.base.Supplier<T> {

        private final java.util.function.Supplier<T> javaSupplier;

        private GuavaSupplier(java.util.function.Supplier<T> javaSupplier) {
            this.javaSupplier = javaSupplier;
        }

        @Override
        public T get() {
            return javaSupplier.get();
        }
    }

    private static class JavaSupplier<T> implements java.util.function.Supplier<T> {

        private final com.google.common.base.Supplier<T> guavaSupplier;

        private JavaSupplier(com.google.common.base.Supplier<T> guavaSupplier) {
            this.guavaSupplier = guavaSupplier;
        }

        @Override
        public T get() {
            return guavaSupplier.get();
        }
    }


}
