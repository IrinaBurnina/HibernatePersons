package ir.bu.hibernatepersons.repository;

import ir.bu.hibernatepersons.model.Contact;
import ir.bu.hibernatepersons.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonsCrudRepository extends JpaRepository<Person, Contact> {
    @Query(value = "select p from Person p where p.cityOfLiving=:city")
    List<Person> findAllByCityOfLiving(@Param("city") String city);

    @Query(value = "select p from Person p where p.contact.age<:age order by p.contact.age asc")
    List<Person> findPeopleByContactAgeIsLessThanOrderByContact_AgeAsc(@Param("age") int age);

    @Query(value = "select p from Person p where p.contact.name=:name and p.contact.surname=:surname")
    Optional<Person> findPersonByContact_NameAndContact_Surname(@Param("name") String name, @Param("surname") String surname);
}
