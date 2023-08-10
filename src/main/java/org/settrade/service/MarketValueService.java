package org.settrade.service;

import org.settrade.dto.MarketValueDto;
import org.settrade.model.MarketValue;

import java.util.List;

public interface MarketValueService {
    MarketValue save(MarketValueDto marketValue);
    List<MarketValue> findMarketValuesByTimeModelId(String id);
    List<MarketValue> findAll();
    MarketValue findById(String id);
    void delete(String id);
    boolean isExist(String id);
    MarketValue updateFromDto(MarketValue existingMarketValue, MarketValueDto updatedMarketValueDto);
}
