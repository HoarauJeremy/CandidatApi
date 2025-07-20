package org.example.candidatapi.dto;

import org.example.candidatapi.entity.Organisation;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Organisation}
 */
public class OrganisationDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String description;
    private final String secteurActivite;
    private final String siteWeb;
    private final String logo;
    private final String email;
    private final String telephone;
    private final String adresse;

    public OrganisationDto(Long id, String nom, String description, String secteurActivite, String siteWeb, String logo, String email, String telephone, String adresse) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.secteurActivite = secteurActivite;
        this.siteWeb = siteWeb;
        this.logo = logo;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public String getLogo() {
        return logo;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganisationDto entity = (OrganisationDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.secteurActivite, entity.secteurActivite) &&
                Objects.equals(this.siteWeb, entity.siteWeb) &&
                Objects.equals(this.logo, entity.logo) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.adresse, entity.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description, secteurActivite, siteWeb, logo, email, telephone, adresse);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nom = " + nom + ", " +
                "description = " + description + ", " +
                "secteurActivite = " + secteurActivite + ", " +
                "siteWeb = " + siteWeb + ", " +
                "logo = " + logo + ", " +
                "email = " + email + ", " +
                "telephone = " + telephone + ", " +
                "adresse = " + adresse + ")";
    }
}