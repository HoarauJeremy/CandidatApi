package org.example.candidatapi.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.example.candidatapi.entity.Commune}
 */
public class CommuneDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String codePostal;
    private final String departement;
    private final String region;
    private final String pays;

    public CommuneDto(Long id, String nom, String codePostal, String departement, String region, String pays) {
        this.id = id;
        this.nom = nom;
        this.codePostal = codePostal;
        this.departement = departement;
        this.region = region;
        this.pays = pays;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getDepartement() {
        return departement;
    }

    public String getRegion() {
        return region;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommuneDto entity = (CommuneDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.codePostal, entity.codePostal) &&
                Objects.equals(this.departement, entity.departement) &&
                Objects.equals(this.region, entity.region) &&
                Objects.equals(this.pays, entity.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, codePostal, departement, region, pays);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nom = " + nom + ", " +
                "codePostal = " + codePostal + ", " +
                "departement = " + departement + ", " +
                "region = " + region + ", " +
                "pays = " + pays + ")";
    }
}