package com.lio.cleanarchitecture.service;

import com.lio.cleanarchitecture.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {
    int addPerson(Person person);

    List<Person> getAllPeople();

    Person getPersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    int deletePersonById(UUID id);
}
