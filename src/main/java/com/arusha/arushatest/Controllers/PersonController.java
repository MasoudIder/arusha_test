package com.arusha.arushatest.Controllers;

import com.arusha.arushatest.Entities.Document;
import com.arusha.arushatest.Entities.Person;
import com.arusha.arushatest.ResponseModel.DocumentResponseModel;
import com.arusha.arushatest.ResponseModel.PersonResponseModel;
import com.arusha.arushatest.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping()
    public ResponseEntity<Set<PersonResponseModel>> getAll() {
        Set<PersonResponseModel> responseModels = new HashSet<>();

        service.findAll().forEach(person -> {
            responseModels.add(new PersonResponseModel(person));
        });

        return new ResponseEntity(responseModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        Optional<Person> person = service.findById(Integer.parseInt(id));

        if (person.isPresent()) {
            return new ResponseEntity<>(new PersonResponseModel(person.get()), HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return new ResponseEntity<>(service.save(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody Person person) {
        Optional<Person> personOptional = service.findById(Integer.parseInt(id));

        if (personOptional.isPresent()) {
            Person foundPerson = personOptional.get();
            foundPerson.setFirstName(person.getFirstName());
            foundPerson.setLastName(person.getLastName());
            foundPerson.setDocumentSet(person.getDocumentSet());
            return new ResponseEntity(service.save(foundPerson), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody String id) {
        Optional<Person> person = service.findById(Integer.parseInt(id));
        if (person.isPresent()) {
            service.delete(person.get().getId());
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
