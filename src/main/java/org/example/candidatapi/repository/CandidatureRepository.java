package org.example.candidatapi.repository;

import org.example.candidatapi.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
}