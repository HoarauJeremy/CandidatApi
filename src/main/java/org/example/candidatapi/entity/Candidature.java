package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "candidature")
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="UTC+4")
    private Date dateCandidature;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private CandidatureStatut statut;

    /*private TypeCandidature typeCandidature;*/

    @Column(nullable = true)
    private String messageMotivation;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
//    @JsonIgnore
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonIgnore
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "offreEmploie_id", nullable = true) // pour candidature spontanée
//    @JsonIgnore
    private OffreEmploie offreEmploie;

    @ManyToMany
//    @JsonIgnore
    private List<Document> documents;

    public Candidature() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCandidature() {
        return dateCandidature;
    }

    public void setDateCandidature(Date dateCandidature) {
        this.dateCandidature = dateCandidature;
    }

    public CandidatureStatut getStatut() {
        return statut;
    }

    public void setStatut(CandidatureStatut statut) {
        this.statut = statut;
    }

    public String getMessageMotivation() {
        return messageMotivation;
    }

    public void setMessageMotivation(String messageMotivation) {
        this.messageMotivation = messageMotivation;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public OffreEmploie getOffreEmploie() {
        return offreEmploie;
    }

    public void setOffreEmploie(OffreEmploie offreEmploie) {
        this.offreEmploie = offreEmploie;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}