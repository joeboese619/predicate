package org.boesenet.predicate.operations;

import org.boesenet.ConnectionError;
import org.boesenet.FilterableHttpResult;

import java.io.Serializable;
import java.util.function.Predicate;

@lombok.Data
public class ConnectionErrorPredicate implements Predicate<FilterableHttpResult>, Serializable {

    private final ConnectionError connectionError;

    @Override
    public boolean test(FilterableHttpResult httpResult) {
        return connectionError.equals(httpResult.getConnectionError());
    }

}
