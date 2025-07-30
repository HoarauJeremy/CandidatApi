package org.example.candidatapi.repository;

import org.example.candidatapi.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Long> {
}