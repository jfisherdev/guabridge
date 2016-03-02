package com.jfisherdev.guabridge.adapters;

/**
 * @author Josh Fisher
 */
public final class PredicateAdapter {

    public static <T> com.google.common.base.Predicate<T> toGuava(java.util.function.Predicate<T> javaPredicate) {
        return new GuavaPredicate<>(javaPredicate);
    }

    public static <T> java.util.function.Predicate<T> fromGuava(com.google.common.base.Predicate<T> guavaPredicate) {
        return new JavaPredicate<>(guavaPredicate);
    }

    private static class GuavaPredicate<T> implements com.google.common.base.Predicate<T> {

        private final java.util.function.Predicate<T> javaPredicate;

        private GuavaPredicate(java.util.function.Predicate<T> javaPredicate) {
            this.javaPredicate = javaPredicate;
        }

        @Override
        public boolean apply(T input) {
            return javaPredicate.test(input);
        }
    }

    private static class JavaPredicate<T> implements java.util.function.Predicate<T> {

        private final com.google.common.base.Predicate<T> guavaPredicate;

        private JavaPredicate(com.google.common.base.Predicate<T> guavaPredicate) {
            this.guavaPredicate = guavaPredicate;
        }

        @Override
        public boolean test(T t) {
            return guavaPredicate.apply(t);
        }
    }


}
