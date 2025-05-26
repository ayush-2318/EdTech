package org.example.repository;

import org.example.entities.ClassEntity;
import org.example.entities.SubjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepo extends CrudRepository<SubjectEntity,Long> {
    Optional<SubjectEntity> findByNameAndClassEntity(String name, ClassEntity classEntity);
}
