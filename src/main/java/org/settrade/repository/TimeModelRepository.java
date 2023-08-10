package org.settrade.repository;

import org.settrade.model.TimeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeModelRepository extends MongoRepository<TimeModel, String> {
}
