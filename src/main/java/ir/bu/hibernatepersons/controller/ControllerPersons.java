package ir.bu.hibernatepersons.controller;

import ir.bu.hibernatepersons.model.Contact;
import ir.bu.hibernatepersons.model.Person;
import ir.bu.hibernatepersons.service.ServicePersons;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class ControllerPersons {
    private final ServicePersons servicePersons;

    public ControllerPersons(ServicePersons servicePersons) {
        this.servicePersons = servicePersons;
    }

    @GetMapping("/hi")
    public String hello() {
        return "Hello>>>WELCOME to BD of persons!";
    }

    @GetMapping("/all_by_city")
    public List<Person> findAllByCityOfLiving(@RequestParam("city") String city) {
        return servicePersons.findAllByCityOfLiving(city);
    }

    @GetMapping("/all-by-younger-than")
    public List<Person> findPeopleByContactAgeIsLessThanOrderByContactContact_AgeAsc(@RequestParam("age") int age) {
        return servicePersons.findPeopleByContactAgeIsLessThanOrderByContact_AgeAsc(age);
    }

    @GetMapping("/one-by-name-and-surname")
    public Optional<Person> findPersonByContact_NameAndContact_Surname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return servicePersons.findPersonByContact_NameAndContact_Surname(name, surname);
    }

    @PostMapping("/create")
    public void create(@RequestBody Person person) {
        servicePersons.save(person);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Person person) {
        servicePersons.delete(person);
    }

    @PostMapping("/update")
    public void update(@RequestBody Person person) {
        servicePersons.save(person);
    }

    @PostMapping("/by-id")
    public Optional<Person> findById(@RequestBody Contact id) {
        return servicePersons.findById(id);
    }

    @GetMapping("/read-all")
    public List<Person> findAll() {
        return servicePersons.findAll();
    }
}

