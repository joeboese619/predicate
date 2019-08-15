package org.boesenet.persistence;

import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class SerializationRepositoryTest extends JPAHibernateTest {

    @Test
    public void testGetObjectById_success() {
        PredicateRecord predicate = em.find(PredicateRecord.class, 1);
        assertNotNull(predicate);
    }

    @Test
    public void testGetAll_success() {
        List<PredicateRecord> books = em.createNamedQuery("Predicate.getAll", PredicateRecord.class).getResultList();
        assertEquals(1, books.size());
    }

    /*
    @Test
    public void testPersist_success() {
        em.getTransaction().begin();
        em.persist(new Book(10, "Unit Test Hibernate/JPA with in memory H2 Database"));
        em.getTransaction().commit();

        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();

        assertNotNull(books);
        assertEquals(2, books.size());
    }

    @Test
    public void testDelete_success(){
        Book book = em.find(Book.class, 1);

        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();

        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();

        assertEquals(0, books.size());
    }
    */
}