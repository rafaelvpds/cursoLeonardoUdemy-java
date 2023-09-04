package com.cursosleandroudemy.person.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.cursosleandroudemy.person.models.Person;

@Service
public class PersonServices {
    private final AtomicLong couter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(Long id) {

        logger.info("Find one Person");

        Person person = new Person();
        person.setId(couter.incrementAndGet());
        person.setFirstName("Rafael");
        person.setLastName("Vinicius");
        person.setAddress("Av Ravena");
        person.setGender("male");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Find All Person");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person created(Person person) {

        Person persons = new Person();
        persons.setId(couter.incrementAndGet());
        persons.setFirstName("Veronica");
        persons.setLastName("Pereira");
        persons.setAddress("Av Ravena");
        persons.setGender("Femia");

        return persons;
    }

    public Person update(Long id, Person person) {
        findById(id);
        return person;
    }

    public void delete(Long id) {
        findById(id);

    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(couter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last Name :" + i);
        person.setAddress("Some address Brasil" + i);
        person.setGender("male" + i);
        return person;
    }

}
