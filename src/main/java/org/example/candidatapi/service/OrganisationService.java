package org.example.candidatapi.service;

import org.example.candidatapi.entity.Organisation;
import org.example.candidatapi.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {

    private final OrganisationRepository organisationRepository;

    @Autowired
    public OrganisationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }

    public Optional<Organisation> getOrganisationById(Long id) {
        return organisationRepository.findById(id);
    }

    public Organisation saveOrganisation(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public void deleteOrganisation(Long id) {
        if (organisationRepository.existsById(id)) {
            organisationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Organisation with id " + id + " not found");
        }
    }

}
