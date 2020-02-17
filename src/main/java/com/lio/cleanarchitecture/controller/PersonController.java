package com.lio.cleanarchitecture.controller;

import com.lio.cleanarchitecture.service.PersonService;
import com.lio.cleanarchitecture.util.factory.PersonFactory;
import com.lio.cleanarchitecture.model.Person;
import com.lio.cleanarchitecture.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody String[] names){
        Person person = new PersonFactory().createPerson(names);
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        //throw new ApiRequestException("cannot get all people");
        return personService.getAllPeople();
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }

    @PutMapping("{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person) {
        personService.updatePersonById(id, person);
    }

    @DeleteMapping("{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePersonById(id);
    }
}
