package com.lio.cleanarchitecture.repository.dao;

import com.lio.cleanarchitecture.model.Person;
import com.lio.cleanarchitecture.repository.FakePersonRepository;
import com.lio.cleanarchitecture.repository.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
public class FakePersonDao implements FakePersonRepository {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int indexOfPersonToUpdate = DB.indexOf(p);
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        DB.remove(person.get());
        return 1;
    }
}
