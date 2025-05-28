package org.example.repository;

import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.example.dto.RetriveDto;
import org.example.entities.ChapterEntity;
import org.example.entities.SubjectEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChapterRepo extends CrudRepository<ChapterEntity,Long> {
    Optional<ChapterEntity> findByNameAndSubjectEntity(String name, SubjectEntity subjectEntity);

    // query to find chapter from subjectid during retrive
    @Query("SELECT c.id AS id, c.name AS name FROM ChapterEntity c WHERE c.subjectEntity.id = :id")
     List<RetriveDto> findChapterById(Long id);

}
