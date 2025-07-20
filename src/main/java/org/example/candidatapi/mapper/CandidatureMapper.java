package org.example.candidatapi.mapper;

import org.example.candidatapi.dto.CandidatureDto;
import org.example.candidatapi.entity.Candidature;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CandidatureMapper {
//    org.example.candidatapi.mapper.CandidatureMapper INSTANCE = Mappers.getMapper(org.example.candidatapi.mapper.CandidatureMapper.class);

    Candidature toEntity(CandidatureDto candidatureDto);

//    @Mapping(target = "utilisateur.motDePasse", ignore = true)
    CandidatureDto toDto(Candidature candidature);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Candidature partialUpdate(CandidatureDto candidatureDto, @MappingTarget Candidature candidature);




}