package org.boesenet.predicate.operations;

import java.io.Serializable;
import java.util.function.Predicate;

@lombok.Data
public class NegateOperation<T> implements Predicate<T>, Serializable {

    private final Predicate<T> rightHandSide;

    @Override
    public boolean test(T value) {
        return ! rightHandSide.test(value);
    }

}
