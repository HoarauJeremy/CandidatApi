package org.example.candidatapi.mapper;

import org.example.candidatapi.dto.OrganisationDto;
import org.example.candidatapi.entity.Organisation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganisationMapper {
    Organisation toEntity(OrganisationDto organisationDto);

    OrganisationDto toDto(Organisation organisation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Organisation partialUpdate(OrganisationDto organisationDto, @MappingTarget Organisation organisation);
}