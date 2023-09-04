package com.cursosleandroudemy.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursosleandroudemy.person.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
