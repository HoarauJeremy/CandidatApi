package org.example.candidatapi.dto;

import org.example.candidatapi.entity.Document;
import org.example.candidatapi.entity.TypeDocument;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link Document}
 */
public class DocumentDto implements Serializable {
    private final Long id;
    private final String nom;
    private final TypeDocument typeDocument;
    private final String urlFichier;
    private final Date creationDate;

    public DocumentDto(Long id, String nom, TypeDocument typeDocument, String urlFichier, Date creationDate) {
        this.id = id;
        this.nom = nom;
        this.typeDocument = typeDocument;
        this.urlFichier = urlFichier;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public String getUrlFichier() {
        return urlFichier;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto entity = (DocumentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.typeDocument, entity.typeDocument) &&
                Objects.equals(this.urlFichier, entity.urlFichier) &&
                Objects.equals(this.creationDate, entity.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, typeDocument, urlFichier, creationDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nom = " + nom + ", " +
                "typeDocument = " + typeDocument + ", " +
                "urlFichier = " + urlFichier + ", " +
                "creationDate = " + creationDate + ")";
    }
}