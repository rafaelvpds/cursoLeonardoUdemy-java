package com.cursosleandroudemy.person.PersonController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursosleandroudemy.person.models.Person;
import com.cursosleandroudemy.person.services.PersonServices;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonServices servicePerson;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person finById(@PathParam(value = "id") Long id) {

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

    @RequestMapping(

            value = "/{id}", method = RequestMethod.PUT,
            // Retornou um json como resposta
            produces = MediaType.APPLICATION_JSON_VALUE,
            // consumiu um json que passamos
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@PathParam(value = "{id}") Long id, @RequestBody Person person) {

        return servicePerson.update(id, person);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathParam(value = "{id}") Long id) {
        servicePerson.delete(id);
    }

}
