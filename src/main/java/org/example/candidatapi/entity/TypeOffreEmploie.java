package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeOffreEmploie {
    ALTERNANCE("Alternance"),
    STAGE("Stage"),
    EMPLOI_ETUDIANT("Emploi étudiant"),
    CDD("CDD"),
    CDI("CDI"),
    FREELANCE("Freelance"),
    BENEVOLAT("Bénévolat"),
    SERVICE_CIVIQUE("Service civique");

    private final String label;

    TypeOffreEmploie(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static TypeOffreEmploie fromLabel(String input) {
        for (TypeOffreEmploie type : TypeOffreEmploie.values()) {
            if (type.label.equalsIgnoreCase(input)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Type d'offre emploi invalide: " + input);
    }
}
