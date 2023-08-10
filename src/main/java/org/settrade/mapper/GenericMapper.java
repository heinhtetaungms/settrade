package org.settrade.mapper;

public interface GenericMapper {
	
	<E, O> O mapToDTO(E entity, Class<O> objClass);

	<D, O> O mapToEntity(D dataDTO, Class<O> objClass);
}
