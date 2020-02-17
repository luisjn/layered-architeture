package com.lio.cleanarchitecture.repository;

import com.lio.cleanarchitecture.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FakePersonRepository {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    int deletePersonById(UUID id);
}
