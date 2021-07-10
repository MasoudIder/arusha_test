package com.arusha.arushatest;

import com.arusha.arushatest.Entities.Document;
import com.arusha.arushatest.Entities.Person;
import com.arusha.arushatest.Services.DocumentService;
import com.arusha.arushatest.Services.PersonService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements ApplicationListener<ContextRefreshedEvent> {

    private PersonService personService;
    private DocumentService documentService;

    public StartUp(PersonService personService, DocumentService documentService) {
        this.personService = personService;
        this.documentService = documentService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //define new persons
        Person person1 = new Person("ali", "ahmadi");
        Person person2 = new Person("reza", "rahmani");
        Person person3 = new Person("hassan", "rostami");
        Person person4 = new Person("mohammad", "akbari");
        Person person5 = new Person("javad", "rezaie");

        //define new documents
        Document document1 = new Document("Cloud_Computing");
        Document document2 = new Document("Data_Base");
        Document document3 = new Document("Machine_Learning");
        Document document4 = new Document("Algorithm");
        Document document5 = new Document("Data_Structure");

        //define relationships
        person1.getDocumentSet().add(document1);
        person1.getDocumentSet().add(document2);
        person1.getDocumentSet().add(document5);

        person2.getDocumentSet().add(document3);
        person2.getDocumentSet().add(document4);

        person3.getDocumentSet().add(document3);
        person3.getDocumentSet().add(document4);
        person3.getDocumentSet().add(document5);

        person4.getDocumentSet().add(document1);
        person4.getDocumentSet().add(document3);

        person5.getDocumentSet().add(document2);
        person5.getDocumentSet().add(document4);
        person5.getDocumentSet().add(document5);

        documentService.save(document1);
        documentService.save(document2);
        documentService.save(document3);
        documentService.save(document4);
        documentService.save(document5);

        personService.save(person1);
        personService.save(person2);
        personService.save(person3);
        personService.save(person4);
        personService.save(person5);


        //do some edits

        //update one person
        Person person = personService.findById(1).get();
        person.setFirstName("ali_reza");
        personService.save(person);

        //update one document
        Document document = documentService.findById(1).get();
        document.setName("Cloud_Computing_Advanced");
        documentService.save(document);


    }
}
