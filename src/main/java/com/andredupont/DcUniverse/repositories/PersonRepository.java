package com.andredupont.DcUniverse.repositories;

import com.andredupont.DcUniverse.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
