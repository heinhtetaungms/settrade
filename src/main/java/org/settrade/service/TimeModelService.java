package org.settrade.service;

import org.settrade.dto.TimeModelDto;
import org.settrade.model.TimeModel;

import java.util.List;

public interface TimeModelService {
    List<TimeModel> findAll();
    TimeModel findById(String id);
    TimeModel save(TimeModelDto timeModelDto);
    void delete(String id);
    boolean isExist(String id);
    TimeModel updateFromDto(TimeModel existingTimeModel, TimeModelDto updatedTimeModelDto);


}
