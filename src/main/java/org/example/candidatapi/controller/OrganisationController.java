package org.example.candidatapi.controller;

import org.example.candidatapi.entity.Organisation;
import org.example.candidatapi.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organisations")
class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @GetMapping
    public List<Organisation> getAll() {
        return organisationService.getAllOrganisations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organisation> getOrganisationById(@PathVariable Long id) {
        Optional<Organisation> organisation = organisationService.getOrganisationById(id);
        return organisation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Organisation addOrganisation(@RequestBody Organisation organisation) {
        return organisationService.saveOrganisation(organisation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
        organisationService.deleteOrganisation(id);
        return ResponseEntity.noContent().build();
    }
}
