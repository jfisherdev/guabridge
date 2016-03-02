package com.jfisherdev.guabridge.adapters;

/**
 * @author Josh Fisher
 */
public final class OptionalAdapter {

    private OptionalAdapter() {
    }

    /**
     *
     * @param javaOptional an {@link java.util.Optional} instance
     * @param <T> the type of the instance to be contained
     * @return an {@link com.google.common.base.Optional} instance with the value contained in {@code javaOptional} if it
     * is present; otherwise {@link com.google.common.base.Optional#absent()}
     */
    public static <T> com.google.common.base.Optional<T> toGuava(java.util.Optional<T> javaOptional) {
        return javaOptional.isPresent() ?
                com.google.common.base.Optional.of(javaOptional.get()) : com.google.common.base.Optional.absent();
    }

    /**
     *
     * @param guavaOptional an {@link com.google.common.base.Optional} instance
     * @param <T> the type of the instance to be contained
     * @return an {@link java.util.Optional} instance with the value contained in {@code guavaOptional} if it is present;
     * otherwise {@link java.util.Optional#empty()}
     */
    public static <T> java.util.Optional<T> fromGuava(com.google.common.base.Optional<T> guavaOptional) {
        return guavaOptional.isPresent() ? java.util.Optional.of(guavaOptional.get()) : java.util.Optional.empty();
    }
}
