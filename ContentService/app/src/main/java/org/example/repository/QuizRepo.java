package org.example.repository;

import org.example.entities.QuizEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface QuizRepo extends CrudRepository<QuizEntity,Long> {
    List<QuizEntity> findByScheduledDate(LocalDate scheduledDate);
}
