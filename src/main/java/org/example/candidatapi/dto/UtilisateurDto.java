package org.example.candidatapi.dto;

import org.example.candidatapi.entity.TypeUtilisateur;
import org.example.candidatapi.entity.Utilisateur;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link Utilisateur}
 */
public class UtilisateurDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String prenom;
    private final String email;
    private final String motDePasse;
    private final TypeUtilisateur typeUtilisateur;
    private final String telephone;
    private final Date dateNaissance;

    public UtilisateurDto(Long id, String nom, String prenom, String email, String motDePasse, TypeUtilisateur typeUtilisateur, String telephone, Date dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.typeUtilisateur = typeUtilisateur;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public TypeUtilisateur getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public String getTelephone() {
        return telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurDto entity = (UtilisateurDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.motDePasse, entity.motDePasse) &&
                Objects.equals(this.typeUtilisateur, entity.typeUtilisateur) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.dateNaissance, entity.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, email, motDePasse, typeUtilisateur, telephone, dateNaissance);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "email = " + email + ", " +
                "motDePasse = " + motDePasse + ", " +
                "typeUtilisateur = " + typeUtilisateur + ", " +
                "telephone = " + telephone + ", " +
                "dateNaissance = " + dateNaissance + ")";
    }
}