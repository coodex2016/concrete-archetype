package org.coodex.example.repos;

import org.coodex.example.entities.AddEntity;
import org.coodex.example.entities.AddId;
import org.springframework.data.repository.CrudRepository;

public interface AddEntityRepo extends CrudRepository<AddEntity, AddId> {
}
