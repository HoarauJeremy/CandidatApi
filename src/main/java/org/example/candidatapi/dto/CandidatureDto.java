package org.example.candidatapi.dto;

import org.example.candidatapi.entity.Candidature;
import org.example.candidatapi.entity.CandidatureStatut;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * DTO for {@link Candidature}
 */
public class CandidatureDto implements Serializable {
    private final Long id;
    private final Date dateCandidature;
    private final CandidatureStatut statut;
    private final String messageMotivation;
    private final OrganisationDto organisation;
    private final UtilisateurDto utilisateur;
    private final OffreEmploieDto offreEmploie;
    private final List<DocumentDto> documents;

    public CandidatureDto(Long id, Date dateCandidature, CandidatureStatut statut, String messageMotivation, OrganisationDto organisation, UtilisateurDto utilisateur, OffreEmploieDto offreEmploie, List<DocumentDto> documents) {
        this.id = id;
        this.dateCandidature = dateCandidature;
        this.statut = statut;
        this.messageMotivation = messageMotivation;
        this.organisation = organisation;
        this.utilisateur = utilisateur;
        this.offreEmploie = offreEmploie;
        this.documents = documents;
    }

    public Long getId() {
        return id;
    }

    public Date getDateCandidature() {
        return dateCandidature;
    }

    public CandidatureStatut getStatut() {
        return statut;
    }

    public String getMessageMotivation() {
        return messageMotivation;
    }

    public OrganisationDto getOrganisation() {
        return organisation;
    }

    public UtilisateurDto getUtilisateur() {
        return utilisateur;
    }

    public OffreEmploieDto getOffreEmploie() {
        return offreEmploie;
    }

    public List<DocumentDto> getDocuments() {
        return documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatureDto entity = (CandidatureDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.dateCandidature, entity.dateCandidature) &&
                Objects.equals(this.statut, entity.statut) &&
                Objects.equals(this.messageMotivation, entity.messageMotivation) &&
                Objects.equals(this.organisation, entity.organisation) &&
                Objects.equals(this.utilisateur, entity.utilisateur) &&
                Objects.equals(this.offreEmploie, entity.offreEmploie) &&
                Objects.equals(this.documents, entity.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCandidature, statut, messageMotivation, organisation, utilisateur, offreEmploie, documents);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dateCandidature = " + dateCandidature + ", " +
                "statut = " + statut + ", " +
                "messageMotivation = " + messageMotivation + ", " +
                "organisation = " + organisation + ", " +
                "utilisateur = " + utilisateur + ", " +
                "offreEmploie = " + offreEmploie + ", " +
                "documents = " + documents + ")";
    }
}