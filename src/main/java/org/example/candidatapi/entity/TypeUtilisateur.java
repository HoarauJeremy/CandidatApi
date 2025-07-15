package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Statut ou type d'utilisateur (Élève, Étudiant, Alternant, etc.)")
public enum TypeUtilisateur {
    @Schema(description = "Élève")
    ELEVE("Élève"),

    @Schema(description = "Étudiant")
    ETUDIANT("Étudiant"),

    @Schema(description = "Alternant")
    ALTERNANT("Alternant"),

    @Schema(description = "Apprenti")
    APPRENTI("Apprenti"),

    @Schema(description = "Stagiaire")
    STAGIAIRE("Stagiaire"),

    @Schema(description = "En recherche d’emploi")
    CHERCHEUR_EMPLOI("En recherche d’emploi"),

    @Schema(description = "Jeune diplômé")
    JEUNE_DIPLOME("Jeune diplômé"),

    @Schema(description = "Salarié")
    SALARIE("Salarié"),

    @Schema(description = "Autre")
    AUTRE("Autre");

    private final String label;

    TypeUtilisateur(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static TypeUtilisateur fromLabel(String label) {
        for (TypeUtilisateur type : TypeUtilisateur.values()) {
            if (type.getLabel().equalsIgnoreCase(label.trim())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Type d'utilisateur invalide: " + label);
    }
}
