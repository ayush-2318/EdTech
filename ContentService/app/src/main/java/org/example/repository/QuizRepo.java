package org.example.repository;

import org.example.entities.QuizEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepo extends CrudRepository<QuizEntity,Long> {
}
