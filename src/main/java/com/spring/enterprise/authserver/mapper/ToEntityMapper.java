package com.spring.enterprise.authserver.mapper;

import com.spring.enterprise.authserver.domain.Entity;
import com.spring.enterprise.authserver.dto.DTO;
import org.mapstruct.MapperConfig;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <E> - Entity type parameter.
 * @param <D> - D type parameter.
 */

@MapperConfig(componentModel = "spring")
public interface ToEntityMapper<E extends Entity, D extends DTO> {

    E toEntity(D dto);

    List<E> toEntity(List<D> dtoList);
}
