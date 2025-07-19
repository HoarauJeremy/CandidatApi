package org.example.candidatapi.repository;

import org.example.candidatapi.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunesRepository extends JpaRepository<Commune, Long> {
}