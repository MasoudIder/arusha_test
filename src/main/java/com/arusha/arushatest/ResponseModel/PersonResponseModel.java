package com.arusha.arushatest.ResponseModel;

import com.arusha.arushatest.Entities.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PersonResponseModel {

    private int id;
    private String firstName;
    private String lastName;

    private Set<String> documents = new HashSet<>();

    public PersonResponseModel(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();

        person.getDocumentSet().forEach(document -> {
            documents.add(document.getName());
        });
    }
}
