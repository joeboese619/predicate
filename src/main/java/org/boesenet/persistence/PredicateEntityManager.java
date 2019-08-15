package org.boesenet.persistence;

import org.boesenet.FilterableHttpResult;
import org.boesenet.serialization.SerializationUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.function.Predicate;

import static org.boesenet.serialization.SerializationUtil.deserializePredicate;

public class PredicateEntityManager {

    private final EntityManager em;

    public PredicateEntityManager(String persistenceUnitName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mnf-pu-test");
        em = emf.createEntityManager();
    }

    Predicate<FilterableHttpResult> getPredicate(Integer id) throws IOException, ClassNotFoundException {
        PredicateRecord p = em.find(PredicateRecord.class, id);
        return SerializationUtil.deserializePredicate(p.getSerializedPredicate());
    }

    void savePredicate(Predicate<FilterableHttpResult> predicate) throws IOException {
        String serializedPredicate = SerializationUtil.serializePredicate(predicate);
        em.getTransaction().begin();
        PredicateRecord predicateRecord = new PredicateRecord();
        predicateRecord.setSerializedPredicate(serializedPredicate);
        em.persist(predicateRecord);
        em.getTransaction().commit();
    }
}
