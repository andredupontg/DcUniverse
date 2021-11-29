package com.andredupont.DcUniverse.services;

import com.andredupont.DcUniverse.entities.Person;
import com.andredupont.DcUniverse.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPeople() { return personRepository.findAll(); }

    public Person getPersonById(Integer personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d does not exist", personId)));
    }

    public Person getPersonByFirstNameAndLastName(String firstName, String lastName){
        return personRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%s %s does not exist", firstName, lastName)));
    }
}
