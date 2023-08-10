package org.settrade.controller;

import lombok.AllArgsConstructor;
import org.settrade.dto.TimeModelDto;
import org.settrade.model.TimeModel;
import org.settrade.service.impl.TimeModelServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class TimeModelController {

    private final TimeModelServiceImpl timeModelService;

    @GetMapping(value = "/time/{id}")
    public ResponseEntity<TimeModel> fetchTimeModel(@PathVariable("id")String timeModelId) {
        TimeModel timeModel = timeModelService.findById(timeModelId);

        return timeModel != null ? ResponseEntity.status(HttpStatus.FOUND).body(timeModel) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/times")
    public List<TimeModel> findAll() {
        return timeModelService.findAll();
    }

    @PostMapping(value = "/time/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeModel> createTimeModel(@RequestBody TimeModelDto timeModelDto) {

        TimeModel timeModel = timeModelService.save(timeModelDto);
        return timeModel != null ? ResponseEntity.status(HttpStatus.CREATED).body(timeModel) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/time/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeModel> updateTimeModel(@PathVariable("id") String timeModelId, @RequestBody TimeModelDto updatedTimeModelDto) {

        TimeModel existingTimeModel = timeModelService.findById(timeModelId);
        if (existingTimeModel == null) {
            return ResponseEntity.notFound().build();
        }

        TimeModel updatedTimeModel = timeModelService.updateFromDto(existingTimeModel, updatedTimeModelDto);

        return updatedTimeModel != null ? ResponseEntity.ok(updatedTimeModel) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/time/delete/{id}")
    public ResponseEntity<TimeModel> deleteTimeModel(@PathVariable("id")String timeModelId) {
        if (timeModelService.isExist(timeModelId)){
            timeModelService.delete(timeModelId);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
