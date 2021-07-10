package com.arusha.arushatest.ResponseModel;

import com.arusha.arushatest.Entities.Document;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class DocumentResponseModel {

    private int id;
    private String name;
    private Set<String> persons = new HashSet<>();


    public DocumentResponseModel(Document document) {
        this.id = document.getId();
        this.name = document.getName();
        document.getPersonSet().forEach(person -> {
            persons.add(person.getFirstName() + "_" + person.getLastName());
        });
    }
}
