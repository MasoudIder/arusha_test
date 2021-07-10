package com.arusha.arushatest.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Persons")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "Person_Document",
            joinColumns = @JoinColumn(name = "personID"),
            inverseJoinColumns = @JoinColumn(name = "documentID")
    )
    private Set<Document> documentSet = new HashSet<>();

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, Set<Document> documentSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentSet = documentSet;
    }
}
