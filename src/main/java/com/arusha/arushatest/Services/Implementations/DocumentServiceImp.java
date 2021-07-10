package com.arusha.arushatest.Services.Implementations;

import com.arusha.arushatest.Entities.Document;
import com.arusha.arushatest.Entities.Repositories.DocumentRepository;
import com.arusha.arushatest.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DocumentServiceImp implements DocumentService {

    @Autowired
    private DocumentRepository repository;

    @Override
    public Optional<Document> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Set<Document> findAll() {
        Set<Document> documents = new HashSet<>();

        repository.findAll().forEach(document -> {
            documents.add(document);
        });

        return documents;
    }

    @Override
    public Document save(Document document) {
        return repository.save(document);

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
