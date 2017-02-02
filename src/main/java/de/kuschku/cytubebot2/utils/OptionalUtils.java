package de.kuschku.cytubebot2.utils;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class OptionalUtils {
    private OptionalUtils() {

    }

    @SafeVarargs
    public static <T> Optional<T> findFirstPresent(Optional<T>... optionals) {
        return Arrays.asList(optionals).stream().filter(Optional::isPresent).findFirst().map(Optional::get);
    }

    public static <A, B> Function<A, B> wrapException(ThrowingFunction<A, B> function, Consumer<Exception> onError) {
        return a -> {
            try {
                return function.apply(a);
            } catch (Exception e) {
                onError.accept(e);
                return null;
            }
        };
    }

    public interface ThrowingFunction<A, B> {
        B apply(A arg) throws Exception;
    }
}
