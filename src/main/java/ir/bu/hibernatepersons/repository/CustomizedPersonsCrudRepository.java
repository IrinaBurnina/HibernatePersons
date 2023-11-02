package ir.bu.hibernatepersons.repository;

import ir.bu.hibernatepersons.model.Contact;
import ir.bu.hibernatepersons.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonsCrudRepository extends JpaRepository<Person, Contact> {
    List<Person> findAllByCityOfLiving(String city);

    List<Person> findAllByContact_AgeOrderByContactAsc(int age);

    List<Person> findPeopleByContactAgeIsLessThanOrderByContact_AgeAsc(int age);

    Optional<Person> findPersonByContact_NameAndContact_Surname(String name, String surname);
}
