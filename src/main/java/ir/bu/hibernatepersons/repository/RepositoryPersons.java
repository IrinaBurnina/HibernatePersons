package ir.bu.hibernatepersons.repository;

import ir.bu.hibernatepersons.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryPersons {
    @PersistenceContext
    private EntityManager entityManager;

    public RepositoryPersons(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    public List<Persons> getPersonByCity (String city){
//        return entityManager.createQuery("select p from Persons p where p.cityOfLiving=:city")
//                .setParameter("city", city)
//                .getResultList();
//    }
    public List<Person> getPersonByCity(String city) {
        String queryText = "select p from Person p where p.cityOfLiving = :city";
        List<Person> persons = entityManager.createQuery(queryText, Person.class)
                .setParameter("city", city)
                .getResultList();
        return persons;
    }
}
