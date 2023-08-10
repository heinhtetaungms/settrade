package org.settrade.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.settrade.dto.TimeModelDto;
import org.settrade.mapper.GenericMapper;
import org.settrade.model.TimeModel;
import org.settrade.repository.TimeModelRepository;
import org.settrade.service.TimeModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class TimeModelServiceImpl implements TimeModelService {
    private final TimeModelRepository timeModelRepository;
    private final GenericMapper mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<TimeModel> findAll() {
        return timeModelRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TimeModel findById(String id) {
        return timeModelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Time Model Id " + id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TimeModel save(TimeModelDto timeModelDto) {
        TimeModel timeModel = timeModelRepository.insert(mapper.mapToEntity(timeModelDto, TimeModel.class));
        log.debug("Saved time model : {}", timeModelDto);
        return timeModel;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(String id) {
        log.debug("Deleted time model by id : {}", id);
        timeModelRepository.deleteById(id);
    }

    @Override
    public boolean isExist(String id) {
        return timeModelRepository.existsById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TimeModel updateFromDto(TimeModel existingTimeModel, TimeModelDto updatedTimeModelDto) {
        existingTimeModel.setHour(updatedTimeModelDto.getHour());
        existingTimeModel.setMinute(updatedTimeModelDto.getMinute());
        existingTimeModel.setFormat(updatedTimeModelDto.getFormat());
        log.debug("Updated time model : {}", existingTimeModel);
        return timeModelRepository.save(existingTimeModel);
    }
}
