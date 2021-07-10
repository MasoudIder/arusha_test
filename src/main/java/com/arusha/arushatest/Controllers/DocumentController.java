package com.arusha.arushatest.Controllers;

import com.arusha.arushatest.Entities.Document;
import com.arusha.arushatest.ResponseModel.DocumentResponseModel;
import com.arusha.arushatest.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService service;

    @GetMapping
    public ResponseEntity<Set<DocumentResponseModel>> getAll() {

        Set<DocumentResponseModel> responseModels = new HashSet<>();

        service.findAll().forEach(document -> {
            responseModels.add(new DocumentResponseModel(document));
        });

        return new ResponseEntity(responseModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        Optional<Document> document = service.findById(Integer.parseInt(id));

        if (document.isPresent()) {
            return new ResponseEntity<>(new DocumentResponseModel(document.get()), HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping
    public ResponseEntity<Document> save(@RequestBody Document document) {
        return new ResponseEntity<>(service.save(document), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody Document document) {
        Optional<Document> documentOptional = service.findById(Integer.parseInt(id));

        if (documentOptional.isPresent()) {
            Document foundDocument = documentOptional.get();
            foundDocument.setName(document.getName());
            foundDocument.setPersonSet(document.getPersonSet());
            return new ResponseEntity(service.save(foundDocument), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody String id) {
        Optional<Document> document = service.findById(Integer.parseInt(id));
        if (document.isPresent()) {
            service.delete(document.get().getId());
            return new ResponseEntity( HttpStatus.OK);

        } else {
            return new ResponseEntity( HttpStatus.NOT_FOUND);

        }
    }
}
