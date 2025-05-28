package org.example.repository;

import org.example.dto.ContentDto;
import org.example.dto.RetriveDto;
import org.example.entities.ContentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ContentRepo extends CrudRepository<ContentEntity,Long> {
    @Query("SELECT c.id AS id, c.title AS title ,c.contentBody as contentBody FROM ContentEntity c WHERE c.topicEntity.id = :id")
    List<ContentDto> findContentById(Long id);
}
