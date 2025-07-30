package org.example.candidatapi.mapper;

import org.example.candidatapi.entity.Utilisateur;
import org.example.candidatapi.dto.UtilisateurDocumentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UtilisateurDocumentMapper {
    Utilisateur toEntity(UtilisateurDocumentDto utilisateurDocumentDto);

    @AfterMapping
    default void linkDocuments(@MappingTarget Utilisateur utilisateur) {
        utilisateur.getDocuments().forEach(document -> document.setUtilisateur(utilisateur));
    }

    UtilisateurDocumentDto toDto(Utilisateur utilisateur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Utilisateur partialUpdate(UtilisateurDocumentDto utilisateurDocumentDto, @MappingTarget Utilisateur utilisateur);
}