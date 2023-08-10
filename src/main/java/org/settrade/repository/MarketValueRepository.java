package org.settrade.repository;

import org.settrade.model.MarketValue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketValueRepository extends MongoRepository<MarketValue, String> {
    List<MarketValue> findByTimeModelId(String timeModelId);

}
