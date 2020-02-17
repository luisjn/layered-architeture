package com.lio.cleanarchitecture.repository;

import com.lio.cleanarchitecture.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
