package org.example.candidatapi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_utilisateur")
    private TypeUtilisateur typeUtilisateur;

    private String telephone;

    private Date dateNaissance;

    @OneToMany(mappedBy = "utilisateur")
    private List<Document> documents;

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune;

    @OneToMany(mappedBy = "utilisateur")
    private List<Candidature> candidatures;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}