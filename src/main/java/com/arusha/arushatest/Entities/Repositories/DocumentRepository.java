package com.arusha.arushatest.Entities.Repositories;

import com.arusha.arushatest.Entities.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Integer> {
}
