package com.arusha.arushatest.Services;

import com.arusha.arushatest.Entities.Document;
import com.arusha.arushatest.Entities.Person;

import java.util.Optional;
import java.util.Set;

public interface PersonService {
    Optional<Person> findById(int id);

    Set<Person> findAll();

    Person save(Person person);

    void delete(int id);
}
