package com.arusha.arushatest.Entities.Repositories;

import com.arusha.arushatest.Entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
