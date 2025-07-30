package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offre_emploie")
public class OffreEmploie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String titre;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_offre_emploie", nullable = false)
    private TypeOffreEmploie typeOffreEmploie;

    @Column(nullable = false)
    private String lieu;

    @Column(nullable = false)
    private Date dateDebut;

    @Column(nullable = false)
    private Date dateFin;

    @Column(nullable = false)
    private Date DatePublication;

    @Enumerated(EnumType.STRING)
    @Column(name = "offre_emploie_statut", nullable = false)
    private OffreEmploieStatut offreEmploieStatut;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "metier_id")
    private Metier metier;

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune;

    @OneToMany(mappedBy = "offreEmploie")
//    @JsonIgnore
    private List<Candidature> candidatures;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeOffreEmploie getTypeOffreEmploie() {
        return typeOffreEmploie;
    }

    public void setTypeOffreEmploie(TypeOffreEmploie typeOffreEmploie) {
        this.typeOffreEmploie = typeOffreEmploie;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDatePublication() {
        return DatePublication;
    }

    public void setDatePublication(Date datePublication) {
        DatePublication = datePublication;
    }

    public OffreEmploieStatut getOffreEmploieStatut() {
        return offreEmploieStatut;
    }

    public void setOffreEmploieStatut(OffreEmploieStatut offreEmploieStatut) {
        this.offreEmploieStatut = offreEmploieStatut;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public Commune getCommunes() {
        return commune;
    }

    public void setCommunes(Commune commune) {
        this.commune = commune;
    }

    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        this.candidatures = candidatures;
    }
}