package org.example.candidatapi.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link org.example.candidatapi.entity.Metier}
 */
public class MetierDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String description;
    private final List<OffreEmploieDto> offreEmploies;

    public MetierDto(Long id, String nom, String description, List<OffreEmploieDto> offreEmploies) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.offreEmploies = offreEmploies;
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

    public List<OffreEmploieDto> getOffreEmploies() {
        return offreEmploies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetierDto entity = (MetierDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.offreEmploies, entity.offreEmploies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description, offreEmploies);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nom = " + nom + ", " +
                "description = " + description + ", " +
                "offreEmploies = " + offreEmploies + ")";
    }
}