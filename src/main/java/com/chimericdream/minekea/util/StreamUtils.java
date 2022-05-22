package com.chimericdream.minekea.util;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {
    public static <T> Stream<T> asStream(Iterator<T> iterator) {
        return asStream(iterator, false);
    }

    public static <T> Stream<T> asStream(Iterator<T> iterator, boolean parallel) {
        Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }
}
