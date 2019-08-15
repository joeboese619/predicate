package org.boesenet.predicate.operations;

import org.boesenet.FilterableHttpResult;
import org.boesenet.HttpMethod;

import java.io.Serializable;
import java.util.function.Predicate;

@lombok.Data
public class HttpMethodPredicate implements Predicate<FilterableHttpResult>, Serializable {


    private final HttpMethod method;

    @Override
    public boolean test(FilterableHttpResult httpResult) {
        return method.equals(httpResult.getHttpMethod());
    }

}
