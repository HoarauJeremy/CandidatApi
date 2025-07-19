package org.example.candidatapi.service;

import org.example.candidatapi.entity.Candidature;
import org.example.candidatapi.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatureService {

    private final CandidatureRepository candidatureRepository;

    @Autowired
    public CandidatureService(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }

    public List<Candidature> findAll() {
        return candidatureRepository.findAll();
    }

    public Optional<Candidature> findById(Long id) {
        return candidatureRepository.findById(id);
    }

    public Candidature addCandidature(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    public void delete(Long id) {
        if (candidatureRepository.existsById(id)) {
            candidatureRepository.deleteById(id);
        } else {
            throw new RuntimeException("Candidature not found with id: " + id);
        }
    }
}
