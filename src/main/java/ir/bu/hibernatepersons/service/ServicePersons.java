package ir.bu.hibernatepersons.service;

import ir.bu.hibernatepersons.model.Contact;
import ir.bu.hibernatepersons.model.Person;
import ir.bu.hibernatepersons.repository.CustomizedPersonsCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePersons {
    private final CustomizedPersonsCrudRepository crudRepository;

    public ServicePersons(CustomizedPersonsCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Person> findAllByCityOfLiving(String city) {
        return crudRepository.findAllByCityOfLiving(city);
    }

    public List<Person> findPeopleByContactAgeIsLessThanOrderByContact_AgeAsc(int age) {
        return crudRepository.findPeopleByContactAgeIsLessThanOrderByContact_AgeAsc(age);
    }

    public Optional<Person> findPersonByContact_NameAndContact_Surname(String name, String surname) {
        return crudRepository.findPersonByContact_NameAndContact_Surname(name, surname);
    }

    public void save(Person person) {
        crudRepository.save(person);
    }

    public void delete(Person person) {
        crudRepository.delete(person);
    }

    public Optional<Person> findById(Contact id) {
        return crudRepository.findById(id);
    }

    public List<Person> findAll() {
        return crudRepository.findAll();
    }
}

