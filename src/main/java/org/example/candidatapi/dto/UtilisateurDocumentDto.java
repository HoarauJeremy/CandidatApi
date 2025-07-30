package org.example.candidatapi.dto;

import jakarta.validation.constraints.Email;
import org.example.candidatapi.entity.Utilisateur;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link Utilisateur}
 */
public class UtilisateurDocumentDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String prenom;
    @Email
    private final String email;
    private final List<DocumentDto> documents;

    public UtilisateurDocumentDto(Long id, String nom, String prenom, String email, List<DocumentDto> documents) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.documents = documents;
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

    public List<DocumentDto> getDocuments() {
        return documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurDocumentDto entity = (UtilisateurDocumentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenom, entity.prenom) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.documents, entity.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, email, documents);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nom = " + nom + ", " +
                "prenom = " + prenom + ", " +
                "email = " + email + ", " +
                "documents = " + documents + ")";
    }
}