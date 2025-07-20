package org.example.candidatapi.mapper;

import org.example.candidatapi.dto.CommuneDto;
import org.example.candidatapi.entity.Commune;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommuneMapper {
    Commune toEntity(CommuneDto communeDto);

    CommuneDto toDto(Commune commune);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Commune partialUpdate(CommuneDto communeDto, @MappingTarget Commune commune);
}