package org.example.candidatapi.service;

import org.example.candidatapi.entity.Commune;
import org.example.candidatapi.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommuneService {

    private final CommuneRepository communeRepository;

    @Autowired
    public CommuneService(CommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }

    public List<Commune> findAllCommunes() {
        return communeRepository.findAll();
    }

    public Optional<Commune> findCommuneById(Long id) {
        return communeRepository.findById(id);
    }

    public Commune saveCommune(Commune commune) {
        return communeRepository.save(commune);
    }

    /*public Commune updateCommune(Commune commune) {
        return communesRepository.save(commune);
    }*/

    public void deleteCommune(Long id) {
        if (communeRepository.existsById(id)) {
            communeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Commune not found");
        }

    }

}
