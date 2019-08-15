package org.boesenet.persistence;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Predicate.getAll", query = "SELECT p FROM PredicateRecord p")
})
@lombok.Data
public class PredicateRecord {

    @Id
    private Integer id;
    private String serializedPredicate;


}
