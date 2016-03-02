package com.jfisherdev.guabridge.adapters;


/**
 * @author Josh Fisher
 */
public final class FunctionAdapter {

    private FunctionAdapter() {
    }

    public static <F, T> com.google.common.base.Function<F, T> toGuava(java.util.function.Function<F, T> javaFunction) {
        return new GuavaFunction<>(javaFunction);
    }

    public static <F, T> java.util.function.Function<F, T> fromGuava(com.google.common.base.Function<F, T> guavaFunction) {
        return new JavaFunction<>(guavaFunction);
    }

    private static class GuavaFunction<F, T> implements com.google.common.base.Function<F, T> {

        private final java.util.function.Function<F, T> javaFunction;

        private GuavaFunction(java.util.function.Function<F, T> javaFunction) {
            this.javaFunction = javaFunction;
        }

        @Override
        public T apply(F input) {
            return javaFunction.apply(input);
        }
    }

    private static class JavaFunction<F, T> implements java.util.function.Function<F, T> {

        private final com.google.common.base.Function<F, T> guavaFunction;

        private JavaFunction(com.google.common.base.Function<F, T> guavaFunction) {
            this.guavaFunction = guavaFunction;
        }

        @Override
        public T apply(F f) {
            return guavaFunction.apply(f);
        }
    }

}
