package org.example.candidatapi.mapper;

import org.example.candidatapi.dto.MetierDto;
import org.example.candidatapi.entity.Metier;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MetierMapper {
    Metier toEntity(MetierDto metierDto);

    @AfterMapping
    default void linkOffreEmploies(@MappingTarget Metier metier) {
        metier.getOffreEmploies().forEach(offreEmploy -> offreEmploy.setMetier(metier));
    }

    MetierDto toDto(Metier metier);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Metier partialUpdate(MetierDto metierDto, @MappingTarget Metier metier);
}