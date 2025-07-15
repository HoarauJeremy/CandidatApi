package org.example.candidatapi.repository;

import org.example.candidatapi.entity.Candidature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CandidatureRepository extends CrudRepository<Candidature, Long> {
}