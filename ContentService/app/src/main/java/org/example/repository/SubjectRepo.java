package org.example.repository;

import org.example.dto.RetriveDto;
import org.example.entities.ClassEntity;
import org.example.entities.SubjectEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepo extends CrudRepository<SubjectEntity,Long> {
    // query to find subject by name and class entity during upload
    Optional<SubjectEntity> findByNameAndClassEntity(String name, ClassEntity classEntity);


    @Query("SELECT c.id AS id, c.name AS name FROM SubjectEntity c WHERE c.classEntity.id = :id")
    List<RetriveDto> findSubjectsById(Long id);



}
