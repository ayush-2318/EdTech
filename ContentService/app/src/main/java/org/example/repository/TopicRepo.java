package org.example.repository;

import org.example.dto.RetriveDto;
import org.example.entities.ChapterEntity;
import org.example.entities.TopicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepo extends CrudRepository<TopicEntity,Long> {
    Optional<TopicEntity> findByNameAndChapterEntity(String name, ChapterEntity chapterEntity);

    // query to find topic from chapterid during retrive
    @Query("SELECT c.id AS id, c.name AS name FROM TopicEntity c WHERE c.chapterEntity.id = :id")
    List<RetriveDto> findTopicById(Long id);
}
