package ir.bu.hibernatepersons.service;

import ir.bu.hibernatepersons.model.Person;
import ir.bu.hibernatepersons.repository.RepositoryPersons;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final RepositoryPersons repository;

    public Service(RepositoryPersons repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonByCity(city);
    }
}
