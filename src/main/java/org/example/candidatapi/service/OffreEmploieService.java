package org.example.candidatapi.service;

import org.example.candidatapi.entity.OffreEmploie;
import org.example.candidatapi.repository.OffreEmploieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreEmploieService {

    private final OffreEmploieRepository offreEmploieRepository;

    @Autowired
    public OffreEmploieService(OffreEmploieRepository offreEmploieRepository) {
        this.offreEmploieRepository = offreEmploieRepository;
    }

    public List<OffreEmploie> findAll() {
        return offreEmploieRepository.findAll();
    }

    public Optional<OffreEmploie> findById(Long id) {
        return offreEmploieRepository.findById(id);
    }

    public OffreEmploie save(OffreEmploie offreEmploie) {
        return offreEmploieRepository.save(offreEmploie);
    }

    public void delete(Long id) {
        if (offreEmploieRepository.existsById(id)) {
            offreEmploieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Offre emploie not found with id: " + id);
        }
    }
}
