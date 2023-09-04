package com.cursosleandroudemy.person.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosleandroudemy.person.exceptions.RessourceNotFoundException;
import com.cursosleandroudemy.person.models.Person;
import com.cursosleandroudemy.person.repositories.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    private String message = " id not found";

    public Person findById(Long id) {

        logger.info("Find one Person");

        return personRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException(id + message));

    }

    public List<Person> findAll() {
        logger.info("Find All Person");

        return personRepository.findAll();
    }

    public Person created(Person person) {

        return personRepository.save(person);
    }

    public Person update(Long id, Person person) {

        var personEntity = personRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException(
                id + message));
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(person.getAddress());
        personEntity.setGender(person.getGender());

        return personEntity;

    }

    public void delete(Long id) {
        var personEntity = personRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException(id + message));

        personRepository.delete(personEntity);

    }

}
