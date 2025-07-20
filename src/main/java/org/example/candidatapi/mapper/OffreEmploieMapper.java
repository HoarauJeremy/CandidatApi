package org.example.candidatapi.mapper;

import org.example.candidatapi.dto.OffreEmploieDto;
import org.example.candidatapi.entity.OffreEmploie;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OffreEmploieMapper {
    OffreEmploie toEntity(OffreEmploieDto offreEmploieDto);

    OffreEmploieDto toDto(OffreEmploie offreEmploie);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OffreEmploie partialUpdate(OffreEmploieDto offreEmploieDto, @MappingTarget OffreEmploie offreEmploie);
}