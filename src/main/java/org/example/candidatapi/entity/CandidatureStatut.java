package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CandidatureStatut {
    // (en attente, accepté, refusé, retiré...)
    EN_ATTENTE("En attent"),
    EN_COURS("En cours de traitement"),
    ENTRETIEN("En entretien"),
    PRESELECTIONNE("Présélectionné"),
    EN_ATTENTE_REPONSE("En attente de réponse"),
    ACCEPTE("Accepté"),
    REFUSE("Refusé"),
    RETIRE("Retiré"),
    ANNULE("Annulé"),
    EMBAUCHE("Embauché");

    private final String label;

    CandidatureStatut(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static CandidatureStatut fromLabel(String label) {
        for (CandidatureStatut statut : CandidatureStatut.values()) {
            if (statut.label.equalsIgnoreCase(label.trim())) {
                return statut;
            }
        }
        throw new IllegalArgumentException(label + " n'existe pas");
    }
}
