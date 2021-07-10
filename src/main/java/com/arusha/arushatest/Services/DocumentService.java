package com.arusha.arushatest.Services;

import com.arusha.arushatest.Entities.Document;

import java.util.Optional;
import java.util.Set;

public interface DocumentService {

    Optional<Document> findById(int id);

    Set<Document> findAll();

    Document save(Document document);

    void delete(int id);

}
