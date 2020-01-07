package com.spring.enterprise.authserver.mapper;

import com.spring.enterprise.authserver.domain.Entity;
import com.spring.enterprise.authserver.dto.DTO;
import org.mapstruct.MapperConfig;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <E> - Entity type parameter.
 * @param <I> - Input DTO type parameter.
 * @param <O> - Output DTO type parameter.
 */

@MapperConfig(componentModel = "spring")
public interface EntityMapper<E extends Entity, I extends DTO, O extends DTO>
        extends ToDtoMapper<E, O>, ToEntityMapper<E, I> {
}
