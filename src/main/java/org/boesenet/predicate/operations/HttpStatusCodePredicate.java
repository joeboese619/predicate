package org.boesenet.predicate.operations;

import org.boesenet.FilterableHttpResult;

import java.io.Serializable;
import java.util.function.Predicate;


@lombok.Data
public class HttpStatusCodePredicate implements Predicate<FilterableHttpResult>, Serializable {

    public enum OPERATION{
        GREATER_THAN,
        GREATER_THAN_OR_EQUAL,
        LESS_THAN,
        LESS_THAN_OR_EQUAL,
        EQUAL
    }

    private final OPERATION statusOperation;
    private final int statusValue;

    @Override
    public boolean test(FilterableHttpResult result) {
        switch(statusOperation){
            case GREATER_THAN:
                return statusValue > result.getStatusCode();
            case GREATER_THAN_OR_EQUAL:
                return statusValue >= result.getStatusCode();
            case LESS_THAN:
                return statusValue < result.getStatusCode();
            case LESS_THAN_OR_EQUAL:
                return statusValue <= result.getStatusCode();
            case EQUAL:
                return statusValue == result.getStatusCode();
            default:
                //hopefully never happens...
                throw new RuntimeException("Unknown operation encountered....");
        }
    }
}
