package org.boesenet;

@lombok.Data
public class FilterableHttpResult {

    private final int statusCode;
    private final ConnectionError connectionError;
    private final HttpMethod httpMethod;


}
