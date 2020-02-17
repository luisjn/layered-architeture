package com.lio.cleanarchitecture.service;

import com.lio.cleanarchitecture.exception.PersonNotFoundException;
import com.lio.cleanarchitecture.repository.FakePersonRepository;
import com.lio.cleanarchitecture.repository.PersonRepository;
import com.lio.cleanarchitecture.model.Person;
import com.lio.cleanarchitecture.repository.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    private final FakePersonRepository fakePersonRepository;
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(FakePersonRepository fakePersonRepository, PersonRepository personRepository) {
        this.fakePersonRepository = fakePersonRepository;
        this.personRepository = personRepository;
    }

    @Override
    public int addPerson(Person person) {
       //return fakePersonRepository.insertPerson(person);
        personRepository.save(new PersonEntity(person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        //return fakePersonRepository.selectAllPeople();
        List<Person> people = new ArrayList();
        for (PersonEntity personEntity : personRepository.findAll()) {
            people.add(new Person(personEntity.getId(), personEntity.getName()));
        }
        return people;
    }

    @Override
    public Person getPersonById(UUID id) throws PersonNotFoundException {
        //return fakePersonRepository.selectPersonById(id);
        PersonEntity personEntity = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return new Person(personEntity.getId(), personEntity.getName());
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return fakePersonRepository.updatePersonById(id, person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return fakePersonRepository.deletePersonById(id);
    }
}
