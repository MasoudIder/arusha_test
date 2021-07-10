package com.arusha.arushatest.Services.Implementations;

import com.arusha.arushatest.Entities.Document;
import com.arusha.arushatest.Entities.Person;
import com.arusha.arushatest.Entities.Repositories.PersonRepository;
import com.arusha.arushatest.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Optional<Person> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Set<Person> findAll() {
        Set<Person> people = new HashSet<>();
        repository.findAll().forEach(person -> {
            people.add(person);
        });

        return people;
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
