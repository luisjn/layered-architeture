package com.lio.cleanarchitecture.util.factory;

import com.lio.cleanarchitecture.model.Person;

public class PersonFactory {
    public Person createPerson(String[] names) {
        String name = convertir(names);
        return new Person(null, name);
    }

    private String convertir(String[] names) {
        return names[0];
    }
}
