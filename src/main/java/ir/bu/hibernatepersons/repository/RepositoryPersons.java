package ir.bu.hibernatepersons.repository;

import ir.bu.hibernatepersons.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class RepositoryPersons {
    @PersistenceContext
    private EntityManager entityManager;

    public RepositoryPersons(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonByCity(String city) {
        return entityManager.createQuery("select p from Person p where p.cityOfLiving = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }

}
