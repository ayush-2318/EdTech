package org.example.repository;

import org.example.dto.RetriveDto;
import org.example.entities.ClassEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepo extends CrudRepository<ClassEntity,Long> {
    Optional<ClassEntity> findByName(String name);



}
