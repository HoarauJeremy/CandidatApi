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

    /**
     * @return La liste de toutes les candidatures
     */
    public List<Candidature> findAllCandidature() {
        return candidatureRepository.findAll();
    }


    /**
     * @param id Identifiant de la candidature
     * @return Les informations d'une candidature
     */
    public Optional<Candidature> findCandidatureById(Long id) {
        return candidatureRepository.findById(id);
    }

    /**
     * @param candidature Données saisie pour une candidature
     * @return La candidature
     */
    public Candidature saveCandidature(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    /**
     * @param id Identifiant de la candidature
     */
    public void deleteCandidature(Long id) {
        if (candidatureRepository.existsById(id)) {
            candidatureRepository.deleteById(id);
        } else {
            throw new RuntimeException("Candidature not found with id: " + id);
        }
    }

    /**
     * @param candidature Données modifier saisies pour une candidature
     * @return la candidature
     */
    public Candidature updateCandidature(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }
}
