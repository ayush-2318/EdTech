package org.example.repository;

import org.example.entities.ChapterEntity;
import org.example.entities.SubjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChapterRepo extends CrudRepository<ChapterEntity,Long> {
    Optional<ChapterEntity> findByNameAndSubjectEntity(String name, SubjectEntity subjectEntity);
}
