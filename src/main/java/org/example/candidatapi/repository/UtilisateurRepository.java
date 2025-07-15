package org.example.candidatapi.repository;

import org.example.candidatapi.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
}