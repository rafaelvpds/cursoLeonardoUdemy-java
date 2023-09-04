package com.cursosleandroudemy.person.PersonController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursosleandroudemy.person.models.Person;
import com.cursosleandroudemy.person.services.PersonServices;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonServices servicePerson;

    @GetMapping("/{id}")
    public Person finById(@PathVariable(value = "id") Long id) {

        return servicePerson.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        return servicePerson.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            // Retornou um json como resposta
            produces = MediaType.APPLICATION_JSON_VALUE,
            // consumiu um json que passamos
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person created(@RequestBody Person person) {
        return servicePerson.created(person);
    }

    @PutMapping(value = "{id}")
    public Person update(@PathVariable(value = "id") Long id, @RequestBody Person person) {

        return servicePerson.update(id, person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        servicePerson.delete(id);
    }

}
