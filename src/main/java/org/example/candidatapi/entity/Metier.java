package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "metier")
public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String description;

    @Column(nullable = true)
    @OneToMany(mappedBy = "metier")
    @JsonIgnore
    private List<OffreEmploie> offreEmploies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OffreEmploie> getOffreEmploies() {
        return offreEmploies;
    }

    public void setOffreEmploies(List<OffreEmploie> offreEmploies) {
        this.offreEmploies = offreEmploies;
    }
}