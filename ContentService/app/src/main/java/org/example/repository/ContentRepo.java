package org.example.repository;

import org.example.entities.ContentEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepo extends CrudRepository<ContentEntity,Long> {
}
