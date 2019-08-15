package org.boesenet.predicate.operations;

import java.io.Serializable;
import java.util.function.Predicate;

@lombok.Data
public class LogicalOrOperation<T> implements Predicate<T>, Serializable {

    private final Predicate<T> leftHandSide;
    private final Predicate<T> rightHandSide;

    @Override
    public boolean test(T value) {
        return leftHandSide.test(value) || rightHandSide.test(value);
    }

}