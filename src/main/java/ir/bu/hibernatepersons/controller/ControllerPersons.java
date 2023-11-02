package ir.bu.hibernatepersons.controller;

import ir.bu.hibernatepersons.model.Person;
import ir.bu.hibernatepersons.service.ServicePersons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class ControllerPersons {
    private final ServicePersons servicePersons;

    public ControllerPersons(ServicePersons servicePersons) {
        this.servicePersons = servicePersons;
    }

    @GetMapping("/all_by_city")
    public List<Person> findAllByCityOfLiving(@RequestParam("city") String city) {
        return servicePersons.findAllByCityOfLiving(city);
    }

    @GetMapping("/all_by_younger_than")
    public List<Person> findAllByContact_AgeOrderByContactAsc(@RequestParam("age") int age) {
        return servicePersons.findAllByContact_AgeOrderByContactAsc(age);
    }

    @GetMapping("/all-by-younger-than")
    public List<Person> findPeopleByContactAgeIsLessThanOrderByContactContact_AgeAsc(@RequestParam("age") int age){
     return servicePersons.findPeopleByContactAgeIsLessThanOrderByContact_AgeAsc(age);
    }

    @GetMapping ("/one-by-name-and-surname")
    public Optional<Person> findPersonByContact_NameAndContact_Surname(@RequestParam("name") String name,@RequestParam("surname") String surname){
       return servicePersons.findPersonByContact_NameAndContact_Surname(name,surname);
    }

}

