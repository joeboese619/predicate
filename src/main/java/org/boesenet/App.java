package org.boesenet;

import org.boesenet.predicate.operations.HttpMethodPredicate;
import org.boesenet.predicate.operations.HttpStatusCodePredicate;
import org.boesenet.predicate.operations.LogicalAndOperation;
import org.boesenet.predicate.operations.LogicalOrOperation;
import org.boesenet.serialization.SerializationUtil;

import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {

        HttpMethodPredicate httpMethodPostPredicate = new HttpMethodPredicate(HttpMethod.POST);
        HttpMethodPredicate httpMethodPutPredicate = new HttpMethodPredicate(HttpMethod.PUT);
        HttpMethodPredicate httpMethodDeletePredicate = new HttpMethodPredicate(HttpMethod.DELETE);

        HttpStatusCodePredicate httpStatus404Predicate = new HttpStatusCodePredicate(HttpStatusCodePredicate.OPERATION.EQUAL, 404);


        LogicalOrOperation innerOr = new LogicalOrOperation(httpMethodPostPredicate,httpMethodPutPredicate);
        LogicalOrOperation outerOr = new LogicalOrOperation(innerOr, httpMethodDeletePredicate);

        LogicalAndOperation outerAnd = new LogicalAndOperation(outerOr, httpStatus404Predicate);

        FilterableHttpResult patch200Result = new FilterableHttpResult(200, ConnectionError.NONE, HttpMethod.PATCH);
        FilterableHttpResult put404Result = new FilterableHttpResult(404, ConnectionError.NONE, HttpMethod.PUT);
        FilterableHttpResult patch404Result = new FilterableHttpResult(404, ConnectionError.NONE, HttpMethod.PATCH);

        System.out.println("We got " + outerOr.test(patch200Result) + " for " + patch200Result);

        System.out.println("We got " + outerAnd.test(patch200Result) + " for " + patch200Result);

        System.out.println("We got " + outerAnd.test(put404Result) + " for " + put404Result);

        String serialized = SerializationUtil.serializePredicate(outerAnd);

        System.out.println("Serialized is " + serialized);

        Predicate<FilterableHttpResult> deserialized = SerializationUtil.deserializePredicate(serialized);

        System.out.println("We got deserialized " + deserialized.test(patch404Result) + " for " + patch404Result);

    }
}
