package org.boesenet.persistence;

import org.boesenet.FilterableHttpResult;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.function.Predicate;

import static org.junit.Assert.assertNotNull;

public class PredicateEntityManagerTest {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    protected static PredicateEntityManager pem;

    @BeforeClass
    public static void init() {
        pem = new PredicateEntityManager("mnf-pu-test");
    }

    @Test
    public void testRetrievalOfPredicate() throws Exception{
        Predicate<FilterableHttpResult> predicate = pem.getPredicate(1);
        assertNotNull(predicate);
        System.out.println("We got back " + predicate);
    }
}
