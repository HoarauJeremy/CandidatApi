package org.example.candidatapi.service;

import org.example.candidatapi.entity.Metier;
import org.example.candidatapi.repository.MetierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetierService {

    private final MetierRepository metierRepository;

    @Autowired
    public MetierService(MetierRepository metierRepository) {
        this.metierRepository = metierRepository;
    }

    public List<Metier> findAll() {
        return metierRepository.findAll();
    }

    public Optional<Metier> findById(Long id) {
        return metierRepository.findById(id);
    }

    public Metier save(Metier metier) {
        return metierRepository.save(metier);
    }

    public Metier update(Metier metier) {
        return metierRepository.save(metier);
    }

    public void deleteById(Long id) {
        if (metierRepository.existsById(id)) {
            metierRepository.deleteById(id);
        } else {
            throw new RuntimeException("Metier not found with id: " + id);
        }
    }
}
