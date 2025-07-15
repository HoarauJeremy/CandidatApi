package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OffreEmploieStatut {
    ACTIVE("Publiée"),
    EN_REDACTION("En rédaction"),
    SUSPENDUE("Suspendue"),
    EXPIREE("Expirée"),
    CLOTUREE("Clôturée"),
    ANNULEE("Annulée");

    private final String label;

    OffreEmploieStatut(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static OffreEmploieStatut fromLabel(String label) {
        for (OffreEmploieStatut statut : OffreEmploieStatut.values()) {
            if (statut.label.equalsIgnoreCase(label.trim())) {
                return statut;
            }
        }
        throw new IllegalArgumentException("Statut d'offre emploi invalide: " + label);
    }
}
