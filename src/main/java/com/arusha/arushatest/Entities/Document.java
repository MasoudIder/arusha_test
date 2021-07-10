package com.arusha.arushatest.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Documents")
@Getter
@Setter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "documentSet")
    private Set<Person> personSet = new HashSet<>();

    public Document() {
    }

    public Document(String name) {
        this.name = name;
    }

    public Document(String name, Set<Person> personSet) {
        this.name = name;
        this.personSet = personSet;
    }
}
