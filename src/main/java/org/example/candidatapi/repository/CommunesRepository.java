package org.example.candidatapi.repository;

import org.example.candidatapi.entity.Commune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommunesRepository extends CrudRepository<Commune, Long> {
}