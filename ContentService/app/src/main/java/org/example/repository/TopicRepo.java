package org.example.repository;

import org.example.entities.ChapterEntity;
import org.example.entities.TopicEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepo extends CrudRepository<TopicEntity,Long> {
    Optional<TopicEntity> findByNameAndChapterEntity(String name, ChapterEntity chapterEntity);
}
