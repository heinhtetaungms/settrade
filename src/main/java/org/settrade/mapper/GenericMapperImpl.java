package org.settrade.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GenericMapperImpl implements GenericMapper{
    private final ModelMapper mapper;

    @Override
    public <E, O> O mapToDTO(E entity, Class<O> objClass) {
        return mapper.map(entity, objClass);
    }

    @Override
    public <D, O> O mapToEntity(D dataDTO, Class<O> objClass) {
        return mapper.map(dataDTO, objClass);
    }
}
