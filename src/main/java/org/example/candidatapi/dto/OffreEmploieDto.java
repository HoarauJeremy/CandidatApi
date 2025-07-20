package org.example.candidatapi.dto;

import org.example.candidatapi.entity.OffreEmploie;
import org.example.candidatapi.entity.OffreEmploieStatut;
import org.example.candidatapi.entity.Organisation;
import org.example.candidatapi.entity.TypeOffreEmploie;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link OffreEmploie}
 */
public class OffreEmploieDto implements Serializable {
    private final Long id;
    private final String titre;
    private final String description;
    private final TypeOffreEmploie typeOffreEmploie;
    private final String lieu;
    private final Date dateDebut;
    private final Date dateFin;
    private final Date DatePublication;
    private final OffreEmploieStatut offreEmploieStatut;

    private final Organisation organisation;

    public OffreEmploieDto(Long id, String titre, String description, TypeOffreEmploie typeOffreEmploie, String lieu, Date dateDebut, Date dateFin, Date datePublication, OffreEmploieStatut offreEmploieStatut, Organisation organisation) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.typeOffreEmploie = typeOffreEmploie;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        DatePublication = datePublication;
        this.offreEmploieStatut = offreEmploieStatut;
        this.organisation = organisation;
    }

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public TypeOffreEmploie getTypeOffreEmploie() {
        return typeOffreEmploie;
    }

    public String getLieu() {
        return lieu;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Date getDatePublication() {
        return DatePublication;
    }

    public OffreEmploieStatut getOffreEmploieStatut() {
        return offreEmploieStatut;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffreEmploieDto entity = (OffreEmploieDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.titre, entity.titre) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.typeOffreEmploie, entity.typeOffreEmploie) &&
                Objects.equals(this.lieu, entity.lieu) &&
                Objects.equals(this.dateDebut, entity.dateDebut) &&
                Objects.equals(this.dateFin, entity.dateFin) &&
                Objects.equals(this.DatePublication, entity.DatePublication) &&
                Objects.equals(this.offreEmploieStatut, entity.offreEmploieStatut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, description, typeOffreEmploie, lieu, dateDebut, dateFin, DatePublication, offreEmploieStatut);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "titre = " + titre + ", " +
                "description = " + description + ", " +
                "typeOffreEmploie = " + typeOffreEmploie + ", " +
                "lieu = " + lieu + ", " +
                "dateDebut = " + dateDebut + ", " +
                "dateFin = " + dateFin + ", " +
                "DatePublication = " + DatePublication + ", " +
                "offreEmploieStatut = " + offreEmploieStatut + ")";
    }
}