package com.lio.cleanarchitecture.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "people")
public class PersonEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String name;

    public PersonEntity() {
    }

    public PersonEntity(String name) {
        this.name = name;
    }
}
