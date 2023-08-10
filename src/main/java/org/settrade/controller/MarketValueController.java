package org.settrade.controller;

import lombok.AllArgsConstructor;
import org.settrade.dto.MarketValueDto;
import org.settrade.model.MarketValue;
import org.settrade.service.MarketValueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class MarketValueController {

    private final MarketValueService marketValueService;

    @GetMapping(value = "/marketValueByTime/{id}")
    public ResponseEntity<List<MarketValue>> fetchMarketValueByTimeModel(@PathVariable("id")String timeModelId) {
        List<MarketValue> marketValueList = marketValueService.findMarketValuesByTimeModelId(timeModelId);

        return !marketValueList.isEmpty() ? ResponseEntity.status(HttpStatus.FOUND).body(marketValueList) : ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/marketValue/{id}")
    public ResponseEntity<MarketValue> fetchMarketValue(@PathVariable("id")String marketValueId) {
        MarketValue marketValue = marketValueService.findById(marketValueId);

        return marketValue != null ? ResponseEntity.status(HttpStatus.FOUND).body(marketValue) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/marketValues")
    public List<MarketValue> findAll() {
        return marketValueService.findAll();
    }

    @PostMapping(value = "/marketValue/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MarketValue> createMarketValue(@RequestBody MarketValueDto marketValueDto) {
        MarketValue marketValue = marketValueService.save(marketValueDto);

        return marketValue != null ? ResponseEntity.status(HttpStatus.CREATED).body(marketValue) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/marketValue/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MarketValue> updateMarketValue(@PathVariable("id") String marketValueId, @RequestBody MarketValueDto updatedMarketValueDto) {

        MarketValue existingMarketValue = marketValueService.findById(marketValueId);
        if (existingMarketValue == null) {
            return ResponseEntity.notFound().build();
        }

        MarketValue updatedMarketValue = marketValueService.updateFromDto(existingMarketValue, updatedMarketValueDto);

        return updatedMarketValue != null ? ResponseEntity.ok(updatedMarketValue) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/marketValue/delete/{id}")
    public ResponseEntity<MarketValue> deleteTimeModel(@PathVariable("id")String marketValueId) {
        if (marketValueService.isExist(marketValueId)){
            marketValueService.delete(marketValueId);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
