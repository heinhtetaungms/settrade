package org.settrade.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.settrade.dto.MarketValueDto;
import org.settrade.mapper.GenericMapper;
import org.settrade.model.MarketValue;
import org.settrade.repository.MarketValueRepository;
import org.settrade.service.MarketValueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MarketValueServiceImpl implements MarketValueService {
    private final MarketValueRepository marketValueRepository;
    private final GenericMapper mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MarketValue save(MarketValueDto marketValue) {
        MarketValue value = marketValueRepository.insert(mapper.mapToEntity(marketValue, MarketValue.class));
        log.debug("Saved market value: {}", marketValue);
        return value;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<MarketValue> findMarketValuesByTimeModelId(String timeModelId) {
        return marketValueRepository.findByTimeModelId(timeModelId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<MarketValue> findAll() {
        return marketValueRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MarketValue findById(String id) {
        return marketValueRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Market Value Id " + id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(String id) {
        log.debug("Deleted market value by id : {}", id);
        marketValueRepository.deleteById(id);
    }

    @Override
    public boolean isExist(String id){
        return marketValueRepository.existsById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MarketValue updateFromDto(MarketValue existingMarketValue, MarketValueDto updatedMarketValueDto) {
        existingMarketValue.setSet(updatedMarketValueDto.getSet());
        existingMarketValue.setValue(updatedMarketValueDto.getValue());
        existingMarketValue.setLuckyNumber(updatedMarketValueDto.getLuckyNumber());
        log.debug("Updated market value: {}", existingMarketValue);
        return marketValueRepository.save(existingMarketValue);
    }


}
