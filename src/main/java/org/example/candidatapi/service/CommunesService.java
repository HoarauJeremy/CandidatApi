package org.example.candidatapi.service;

import org.example.candidatapi.entity.Commune;
import org.example.candidatapi.repository.CommunesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunesService {

    private final CommunesRepository communesRepository;

    @Autowired
    public CommunesService(CommunesRepository communesRepository) {
        this.communesRepository = communesRepository;
    }

    public List<Commune> getAllCommunes() {
        return communesRepository.findAll();
    }

    public Optional<Commune> getCommuneById(Long id) {
        return communesRepository.findById(id);
    }

    public Commune addCommune(Commune commune) {
        return communesRepository.save(commune);
    }

    /*public Commune updateCommune(Commune commune) {
        return communesRepository.save(commune);
    }*/

    public void deleteCommune(Long id) {
        if (communesRepository.existsById(id)) {
            communesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Commune not found");
        }

    }

}
